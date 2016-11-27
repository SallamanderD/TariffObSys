package ua.nure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.DAO.*;
import ua.nure.entities.TariffCommentary;
import ua.nure.entities.Telephone;
import ua.nure.entities.User;
import ua.nure.util.Validator;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.util.*;

/**
 * Created by Александр Доротенко on 06.11.2016.
 */
@Controller
public class HomeController {

    //Data access classes
    @Autowired
    private RoleDAO roleDAO;
    @Autowired
    private OperatorDAO operatorDAO;
    @Autowired
    private TariffDAO tariffDAO;
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private TariffCommentaryDAO tariffCommentaryDAO;
    @Autowired
    Emulator emulator;
    @Autowired
    HttpSession httpSession;
    @Autowired
    TelephoneDAO telephoneDAO;
    private final String CURRENT_ID_PARAM = "currentId";


    @RequestMapping(value = "/")
    public ModelAndView index(){
        //emulator.emul();
        ModelAndView model = new ModelAndView("index");
        return model;
    }
    @RequestMapping(value = "/mainmenu")
    public ModelAndView mainmenu(){
        if(httpSession.getAttributeNames().hasMoreElements()){
            ModelAndView model = new ModelAndView("mainmenu");
            model.addObject("user", userDAO.findUser((Integer)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0));
            return model;
        }
        ModelAndView model = new ModelAndView("mainmenu");
        model.addObject("user", null);
        return model;
    }

    @RequestMapping(value = "/tariffCommentary")
    public ModelAndView tariffCommentary(@RequestParam(value = "tariffId") int tariffID){
        ModelAndView model = new ModelAndView("tariffCommentary");
        List<TariffCommentary> comment = tariffCommentaryDAO.findByTariffId(tariffID);
        Collections.sort(comment, new Comparator<TariffCommentary>() {
            @Override
            public int compare(TariffCommentary o1, TariffCommentary o2) {
                return o1.getCreateDate().compareTo(o2.getCreateDate());
            }
        });
        Collections.reverse(comment);
        model.addObject("commentaries", comment);
        if(httpSession.getAttributeNames().hasMoreElements()){
            model.addObject("userId", (Integer)httpSession.getAttribute(CURRENT_ID_PARAM));
        } else{
            model.addObject("userId", null);
        }
        return model;
    }

    @RequestMapping(value = "/addTariffCommentary")
    public ModelAndView addTarCommentary(@RequestParam(value = "text") String text, @RequestParam(value = "tariffId") int tariffId){
        TariffCommentary temp = new TariffCommentary(tariffCommentaryDAO.findAll().size() + 1,
                userDAO.findUser((Integer)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0), text, tariffId);
        tariffCommentaryDAO.save(temp);
        tariffDAO.addCommentaries(tariffId, tariffCommentaryDAO.findById(temp.getId()));
        ModelAndView model = new ModelAndView("redirect:tariff/" + tariffId);
        return model;
    }

    @RequestMapping(value = "/tariff/{id}")
    public ModelAndView tariffView(@PathVariable int id){
        ModelAndView model = new ModelAndView("tariff");
        model.addObject("tariff", tariffDAO.findTariff(id).get(0));
        return model;
    }

    @RequestMapping(value = "tariffs")
    public ModelAndView tariffs(){
        ModelAndView model = new ModelAndView("tariffs");
        model.addObject("tariffs", tariffDAO.findAllTariff());
        return model;
    }
    @RequestMapping(value = "/register")
    public ModelAndView register(){
        if(httpSession.getAttributeNames().hasMoreElements()){
            ModelAndView model = new ModelAndView("index");
            return model;
        }
        ModelAndView model = new ModelAndView("register");
        return model;
    }

    // TODO: Optimize method
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView signup(@RequestParam("username") String username, @RequestParam("password") String password,
                               @RequestParam("name") String name, @RequestParam("surname") String surname,
                               @RequestParam("mail") String mail, @RequestParam("repassword") String repassword){
        if(httpSession.getAttributeNames().hasMoreElements()){
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        List<String> error = new ArrayList<>();
        //Validation
        if(!Validator.validateUsername(username)){
            error.add("Username must be from 3 to 20 symbols and contains only latin letters and numeral, \"-\" and \"_\" are available too.\n");
        }
        if(!Validator.validateEmail(mail)){
            error.add("Incorrect Email.\n");
        }
        if(password.equals("")){
            error.add("Enter password.\n");
        }
        if(!password.equals(repassword)){
            error.add("Check your password.\n");
        }
        if(!Validator.validateName(name) || !Validator.validateName(surname)){
            error.add("Enter correct Name and Surname.\n");
        }
        if(userDAO.findByUsername(username) != null){
            error.add("Username is already exist.\n");
        }
        if(userDAO.findByEmail(mail) != null){
            error.add("Email is already exist.\n");
        }
        if(error.size() == 0){
            ModelAndView model = new ModelAndView("activate");
            User usr = new User(username, DigestUtils.md5DigestAsHex(password.getBytes()), name, surname, mail);
            usr.setId(userDAO.getSize() + 1);
            usr.setRole(roleDAO.findRole(1).get(0));
            usr.setActivated(Validator.createPass());
            userDAO.saveUser(usr);
            Sender sender = new Sender("TariffObSys@gmail.com", "#af45Ecsrg67&");
            sender.send("Register into TOS", "Hello " + surname + " " + name + ".\nYour code: " + usr.getActivated(), "TOS Command", mail);
            httpSession.setAttribute(CURRENT_ID_PARAM, usr.getId());
            model.addObject("mail", Validator.createLinkToEmail(usr.getMail()));
            return model;
        }
        ModelAndView model = new ModelAndView("register");
        model.addObject("error", error);
        model.addObject("username", username);
        model.addObject("name", name);
        model.addObject("surname", surname);
        model.addObject("mail", mail);
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(){
        httpSession.removeAttribute(CURRENT_ID_PARAM);
        ModelAndView model = new ModelAndView("redirect:/");
        return model;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin(){
        if(httpSession.getAttributeNames().hasMoreElements()){
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        ModelAndView model = new ModelAndView("signin");
        return model;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView signinPOST(@RequestParam("username") String username, @RequestParam("password") String password){
        if(userDAO.findByUsername(username) != null){
            if(DigestUtils.md5DigestAsHex(password.getBytes()).
                    equals(userDAO.findByUsername(username).getPassword())){
                httpSession.setAttribute(CURRENT_ID_PARAM, userDAO.findByUsername(username).getId());
                ModelAndView model = new ModelAndView("redirect:/");
                return model;
            }
        }
        ModelAndView model = new ModelAndView("signin");
        model.addObject("error", "Wrong username or password");
        return model;
    }

    @RequestMapping(value = "/profile")
    public ModelAndView userExplore(){
        if(!httpSession.getAttributeNames().hasMoreElements()){
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        ModelAndView model = new ModelAndView("user");
        model.addObject("user", userDAO.findUser((Integer)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0));
        return model;
    }

    @RequestMapping(value = "/changeUser")
    public ModelAndView changeUser(){
        ModelAndView model = new ModelAndView("changeUser");
        User currentUser = userDAO.findUser((Integer)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0);
        model.addObject("user", currentUser);
        return model;
    }

    @RequestMapping(value = "/changeUser", method = RequestMethod.POST)
    public ModelAndView changeUserPOST(@RequestParam("username") String username, @RequestParam("name") String name,
                                       @RequestParam("surname") String surname){
        User currentUser = userDAO.findUser((Integer)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0);
        if(username.equals("") || name.equals("") || surname.equals("")){
            ModelAndView model = new ModelAndView("changeUser");
            model.addObject("error", "You must enter all parameters");
            model.addObject("user", userDAO.findUser((Integer)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0));
            return model;
        }
        if(userDAO.findByUsername(username) == null || userDAO.findByUsername(username)
                .getUsername().equals(currentUser.getUsername())){
            currentUser.setUsername(username);
            currentUser.setName(name);
            currentUser.setSurname(surname);
            userDAO.updateUserData(userDAO.findUser((Integer)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getId(), currentUser);
            ModelAndView model = new ModelAndView("redirect:user");
            model.addObject("user", currentUser);
            return model;
        }
        else{
            ModelAndView model = new ModelAndView("changeUser");
            model.addObject("error", "Username is already exist.");
            model.addObject("user", userDAO.findUser((Integer)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0));
            return model;
        }

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(String str){
        List<Telephone> telephones = telephoneDAO.findAll();
        List<Telephone> result = new ArrayList<>();
        for(Telephone t : telephones){
            if(t.getNumber().contains(str)){
                result.add(t);
            }
        }

    }

    @RequestMapping(value = "/changePassword")
    public ModelAndView changePassword(){
        return new ModelAndView("changePassword");
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ModelAndView changePasswordPOST(@RequestParam("oldpassword") String oldpassword, @RequestParam("password") String password,
                                           @RequestParam("repassword") String repassword){
        User currentUser = userDAO.findUser((Integer)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0);
        if(currentUser.getPassword().equals(DigestUtils.md5DigestAsHex(oldpassword.getBytes()))){
            if(password.equals(repassword)){
                currentUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
                userDAO.updateUserPass(currentUser.getId(), currentUser);
                ModelAndView model = new ModelAndView("redirect:user");
                model.addObject("user", currentUser);
                return model;
            }
            else{
                ModelAndView model = new ModelAndView("changePassword");
                model.addObject("error", "Passwords do not match");
                return model;
            }
        }
        else{
            ModelAndView model = new ModelAndView("changePassword");
            model.addObject("error", "Wrong old password");
            return model;
        }
    }

    @RequestMapping(value = "activate", method = RequestMethod.GET)
    public ModelAndView activate(){
        User currentUser = userDAO.findUser((Integer)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0);
        ModelAndView model = new ModelAndView("activate");
        model.addObject("mail", Validator.createLinkToEmail(currentUser.getMail()));
        return model;
    }
    @RequestMapping(value = "activate", method = RequestMethod.POST)
    public ModelAndView activate(@RequestParam("code") String code){
        User currentUser = userDAO.findUser((Integer)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0);
        if(currentUser.getActivated().equals(code)){
            currentUser.setActivated(null);
            userDAO.updateActivated(currentUser.getId(), currentUser);
        }
        ModelAndView model = new ModelAndView("redirect:/");
        return model;
    }

}
