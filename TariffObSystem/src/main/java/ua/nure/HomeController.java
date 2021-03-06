package ua.nure;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.DAO.*;
import ua.nure.entities.*;
import ua.nure.util.Pair;
import ua.nure.util.Validator;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    @Autowired
    private ParameterDAO parameterDAO;
    @Autowired
    TelephoneCommentaryDAO telephoneCommentaryDAO;
    private final String CURRENT_ID_PARAM = "currentId";


    @RequestMapping(value = "/")
    public ModelAndView index() {
        //emulator.emul();
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @RequestMapping(value = "/mainmenu")
    public ModelAndView mainmenu() {
        if (httpSession.getAttributeNames().hasMoreElements()) {
            if (userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).isBanned()) {
                return new ModelAndView("redirect:/logout");
            }
            ModelAndView model = new ModelAndView("mainmenu");
            model.addObject("user", userDAO.findUser((Integer) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0));
            return model;
        }
        ModelAndView model = new ModelAndView("mainmenu");
        model.addObject("user", null);
        return model;
    }

    @RequestMapping(value = "/deleteTariffCommentary", method = RequestMethod.POST)
    public ModelAndView deleteTariffCommentary(@RequestParam(value = "id") int tariffCommentaryId, @RequestParam(value = "authorId") int authorId, @RequestParam(value = "tariffId") int tariffId) {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            return new ModelAndView("redirect:/");
        } else {
            if (userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
                tariffCommentaryDAO.delete(tariffCommentaryId);
                userDAO.decrementTariffCommentary(tariffCommentaryDAO.findById(tariffCommentaryId).getAuthor().getId());
                return new ModelAndView("redirect:/adminPanel");
            }
            if ((int) httpSession.getAttribute(CURRENT_ID_PARAM) == authorId) {
                tariffCommentaryDAO.delete(tariffCommentaryId);
                userDAO.decrementTariffCommentary(authorId);
                return new ModelAndView("redirect:/tariff/" + tariffId);
            }
            return new ModelAndView("redirect:/tariff/" + tariffId);
        }
    }



    @RequestMapping(value = "/deleteTelephoneCommentary", method = RequestMethod.POST)
    public ModelAndView deleteTelephoneCommentary(@RequestParam(value = "id") int telephoneCommentaryId, @RequestParam(value = "authorId") int authorId, @RequestParam(value = "telephoneId") int telephoneId) {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            return new ModelAndView("redirect:/");
        } else {
            if (userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
                telephoneCommentaryDAO.delete(telephoneCommentaryId);
                userDAO.decrementTelephoneCommentary(telephoneCommentaryDAO.findById(telephoneCommentaryId).getAuthor().getId());
                return new ModelAndView("redirect:/adminPanel");
            }
            if ((int) httpSession.getAttribute(CURRENT_ID_PARAM) == authorId) {
                telephoneCommentaryDAO.delete(telephoneCommentaryId);
                userDAO.decrementTelephoneCommentary(authorId);
                return new ModelAndView("redirect:/telephone/" + telephoneId);
            }
            return new ModelAndView("redirect:/telephone/" + telephoneId);
        }
    }

    @RequestMapping(value = "/banUser", method = RequestMethod.POST)
    public ModelAndView banUser(int id) {
        if (httpSession.getAttributeNames().hasMoreElements() && userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
            if (userDAO.findUser(id).size() == 1) {
                userDAO.ban(id);

            }
            return new ModelAndView("redirect:/adminPanel");
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/unbanUser", method = RequestMethod.POST)
    public ModelAndView unbanUser(int id) {
        if (httpSession.getAttributeNames().hasMoreElements() && userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
            if (userDAO.findUser(id).size() == 1) {
                userDAO.unban(id);
            }
            return new ModelAndView("redirect:/adminPanel");
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/tariffCommentary")
    public ModelAndView tariffCommentary(@RequestParam(value = "tariffId") int tariffID) {
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
        model.addObject("count", comment.size());
        if (httpSession.getAttributeNames().hasMoreElements()) {
            model.addObject("userId", (Integer) httpSession.getAttribute(CURRENT_ID_PARAM));
            model.addObject("tariffId", tariffID);
        } else {
            model.addObject("userId", null);
        }
        return model;
    }

    @RequestMapping(value = "operator/{name}", method = RequestMethod.GET)
    public ModelAndView operators(@PathVariable(value = "name") String name) {
        ModelAndView model = new ModelAndView("tariffs");
        List<Tariff> result = new ArrayList<>();
        for (Tariff t : tariffDAO.findAllTariff()) {
            if (t.getOperator().getName().equals(name) && t.isDeleted() == false) {
                result.add(t);
            }
        }
        model.addObject("tariffs", result);
        return model;
    }

    @RequestMapping(value = "/createTariff")
    public ModelAndView createTariff() {
        if (httpSession.getAttributeNames().hasMoreElements() && userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
            ModelAndView model = new ModelAndView("createTariff");
            model.addObject("operators", operatorDAO.findAllOperators());
            return model;
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/createTariff", method = RequestMethod.POST)
    public ModelAndView createTariffPOST(@RequestParam(value = "name") String name,
                                         @RequestParam(value = "shortDescription") String shortDescription,
                                         @RequestParam(value = "description") String description,
                                         @RequestParam(value = "count") String count,
                                         @RequestParam(value = "threeG") String threeG,
                                         @RequestParam(value = "inCalls") String inCalls,
                                         @RequestParam(value = "outCalls") String outCalls,
                                         @RequestParam(value = "vk", required = false) String vk,
                                         @RequestParam(value = "fb", required = false) String fb,
                                         @RequestParam(value = "ok", required = false) String ok,
                                         @RequestParam(value = "tw", required = false) String tw,
                                         @RequestParam(value = "sms") String sms,
                                         @RequestParam(value = "operator") int operator) {
        if (httpSession.getAttributeNames().hasMoreElements() && userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
            Tariff t = new Tariff(tariffDAO.findAllTariff().size() + 1, name, shortDescription, description, new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
            t.setOperator(operatorDAO.findOperator(operator).get(0));
            t.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(1), count));
            t.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(2), threeG));
            t.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(3), inCalls));
            t.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(4), outCalls));
            String social = "";
            if (Boolean.valueOf(vk)) {
                social += "VK, ";
            }
            if (Boolean.valueOf(fb)) {
                social += "Facebook, ";
            }
            if (Boolean.valueOf(ok)) {
                social += "Одноклассники, ";
            }
            if (Boolean.valueOf(tw)) {
                social += "Twitter";
            }
            t.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(5), social));
            t.getParameters().add(new Pair<Parameter, String>(parameterDAO.findFirst(6), sms));
            tariffDAO.saveTariff(t);
            return new ModelAndView("redirect:/tariff/" + t.getId());
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/allTelephones")
    public ModelAndView allTelephones() {
        if (httpSession.getAttributeNames().hasMoreElements() && userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
            ModelAndView model = new ModelAndView("allTelephones");
            model.addObject("telephones", telephoneDAO.findAll());
            return model;
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/telephoneCommentary")
    public ModelAndView telephoneCommentary(@RequestParam(value = "telephoneId") int telephoneId) {
        ModelAndView model = new ModelAndView("telephoneCommentary");
        List<TelephoneCommentary> comment = telephoneCommentaryDAO.findByTelephoneId(telephoneId);
        Collections.sort(comment, new Comparator<TelephoneCommentary>() {
            @Override
            public int compare(TelephoneCommentary o1, TelephoneCommentary o2) {
                return o1.getCreateDate().compareTo(o2.getCreateDate());
            }
        });
        model.addObject("commentaries", comment);
        model.addObject("count", comment.size());
        if (httpSession.getAttributeNames().hasMoreElements()) {
            model.addObject("userId", (Integer) httpSession.getAttribute(CURRENT_ID_PARAM));
            model.addObject("telephoneId", telephoneId);

        } else {
            model.addObject("userId", null);
        }
        return model;
    }

    @RequestMapping(value = "/addTariffCommentary")
    public ModelAndView addTarCommentary(@RequestParam(value = "text") String text, @RequestParam(value = "tariffId") int tariffId) {
        if (httpSession.getAttributeNames().hasMoreElements()) {
            TariffCommentary temp = new TariffCommentary(tariffCommentaryDAO.findAll().size() + 1,
                    userDAO.findUser((Integer) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0), text, tariffId);
            tariffCommentaryDAO.save(temp);
            tariffDAO.addCommentaries(tariffId, tariffCommentaryDAO.findById(temp.getId()));
            userDAO.incrementTariffCommentary((int) httpSession.getAttribute(CURRENT_ID_PARAM));
        }
        ModelAndView model = new ModelAndView("redirect:tariff/" + tariffId);
        return model;
    }

    @RequestMapping(value = "/addTelephoneCommentary")
    public ModelAndView addTelCommentary(@RequestParam(value = "text") String text, @RequestParam(value = "telephoneId") int telephoneId) {
        if (httpSession.getAttributeNames().hasMoreElements()) {
            TelephoneCommentary temp = new TelephoneCommentary(telephoneCommentaryDAO.findAll().size() + 1,
                    userDAO.findUser((Integer) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0), text, telephoneId);
            telephoneCommentaryDAO.save(temp);
            telephoneDAO.addCommentaries(telephoneId, telephoneCommentaryDAO.findById(temp.getId()));
            userDAO.incrementTelephoneCommentary((int) httpSession.getAttribute(CURRENT_ID_PARAM));
        }
        ModelAndView model = new ModelAndView("redirect:telephone/" + telephoneId);
        return model;
    }

    @RequestMapping(value = "/tariff/{id}")
    public ModelAndView tariffView(@PathVariable int id) {
        if(httpSession.getAttributeNames().hasMoreElements() == false || userDAO.findUser((int)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 1){
            if(tariffDAO.findTariff(id).get(0).isDeleted())
                return new ModelAndView("redirect:/");
        }
        ModelAndView model = new ModelAndView("tariff");
        model.addObject("tariff", tariffDAO.findTariff(id).get(0));
        return model;
    }

    @RequestMapping(value = "/telephone/{id}")
    public ModelAndView telephoneView(@PathVariable int id) {
        if(httpSession.getAttributeNames().hasMoreElements() == false || userDAO.findUser((int)httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 1){
            if(telephoneDAO.findById(id).isDeleted())
                return new ModelAndView("redirect:/");
        }
        ModelAndView model = new ModelAndView("telephonePage");
        model.addObject("telephone", telephoneDAO.findById(id));
        return model;
    }

    @RequestMapping(value = "/allUsers")
    public ModelAndView allUsers(){
        if (httpSession.getAttributeNames().hasMoreElements() && userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
            ModelAndView model = new ModelAndView("allUsers");
            model.addObject("users", userDAO.findAllUser());
            return model;
        }
        return new ModelAndView("redirect:/");

    }

    @RequestMapping(value = "allTariffCommentaries")
    public ModelAndView allTariffCommentaries(){
        if (httpSession.getAttributeNames().hasMoreElements() && userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
            ModelAndView model = new ModelAndView("allTariffCommentaries");
            model.addObject("tariffCommentaries", tariffCommentaryDAO.findAll());
            return model;
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/footer")
    public ModelAndView footer(){
        return new ModelAndView("footer");
    }

    @RequestMapping(value = "allTelephoneCommentaries")
    public ModelAndView allTelephoneCommentaries(){
        if (httpSession.getAttributeNames().hasMoreElements() && userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
            ModelAndView model = new ModelAndView("allTelephoneCommentaries");
            model.addObject("tariffCommentaries", telephoneCommentaryDAO.findAll());
            return model;
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "tariffs")
    public ModelAndView tariffs() {
        ModelAndView model = new ModelAndView("tariffs");
        List<Tariff> tariffs = new ArrayList<>();
        for (Tariff t : tariffDAO.findAllTariff())
            if (t.isDeleted() == false)
                tariffs.add(t);
        model.addObject("tariffs", tariffs);
        return model;
    }

    @RequestMapping(value = "/createTelephone")
    public ModelAndView createTelephone() {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        ModelAndView model = new ModelAndView("createTelephone");
        return model;
    }

    @RequestMapping(value = "createTelephone", method = RequestMethod.POST)
    public ModelAndView createTelephone(@RequestParam(value = "telephone") String telephone,
                                        @RequestParam(value = "description") String description) {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:index");
            return model;
        }
        List<String> error = new ArrayList<>();
        for (Telephone t : telephoneDAO.findAll()) {
            if (telephone.equals(t.getNumber())) {
                error.add("Такой номер уже существует, перейдите к нему через поиск.");
            }
        }
        if (telephone.equals("")) {
            error.add("Телефон не должен быть пустым.");
        }
        if (description.equals("")) {
            error.add("Описание не должно быть пустым.");
        }
        if (error.size() == 0) {
            telephoneDAO.save(new Telephone(telephoneDAO.findAll().size() + 1, telephone, description, (Integer) httpSession.getAttribute(CURRENT_ID_PARAM)));
            ModelAndView model = new ModelAndView("redirect:telephone/" + telephoneDAO.findAll().size());
            userDAO.incrementTelephoneCreated((int) httpSession.getAttribute(CURRENT_ID_PARAM));
            return model;
        } else {
            ModelAndView model = new ModelAndView("createTelephone");
            model.addObject("error", error);
            return model;
        }

    }

    @RequestMapping(value = "/register")
    public ModelAndView register() {
        if (httpSession.getAttributeNames().hasMoreElements()) {
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
                               @RequestParam("mail") String mail, @RequestParam("repassword") String repassword) {
        if (httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        List<String> error = new ArrayList<>();
        //Validation
        if (!Validator.validateUsername(username)) {
            error.add("Логин должен быть от 7 до 20 символов и содержать только латиницу и цифру, \"-\" и \"_\" доступны также.\n");
        }
        if (!Validator.validatePass(password)) {
            error.add("Пароль должен быть 8 и больше символов.");
        }
        if (!Validator.validateEmail(mail)) {
            error.add("Проверьте правильность ввода эл. почты.\n");
        }
        if (password.equals("")) {
            error.add("Введите пароль.\n");
        }
        if (!password.equals(repassword)) {
            error.add("Пароли не совпадают.\n");
        }
        if (!Validator.validateName(name) || !Validator.validateName(surname)) {
            error.add("Введите правильное имя или фамилию.\n");
        }
        if (userDAO.findByUsername(username) != null) {
            error.add("Логин уже исользуется.\n");
        }
        if (userDAO.findByEmail(mail) != null) {
            error.add("Эл. почта уже используется.\n");
        }
        if (error.size() == 0) {
            ModelAndView model = new ModelAndView("activate");
            User usr = new User(username, DigestUtils.md5DigestAsHex(password.getBytes()), name, surname, mail);
            usr.setId(userDAO.getSize() + 1);
            usr.setRole(roleDAO.findRole(1).get(0));
            usr.setActivated(Validator.createPass());
            userDAO.saveUser(usr);
            Sender sender = new Sender("TariffObSys@gmail.com", "#af45Ecsrg67&");
            sender.send("Регистрация в TOS", "Здравствуйте " + surname + " " + name + ".\nВаш код: " + usr.getActivated(), "TOS Command", mail);
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
    public ModelAndView logout() {
        httpSession.removeAttribute(CURRENT_ID_PARAM);
        ModelAndView model = new ModelAndView("redirect:/");
        return model;
    }

    @RequestMapping(value = "/filter", method = RequestMethod.POST)
    public ModelAndView filter(@RequestParam(value = "GLow") String GLow,
                               @RequestParam(value = "GHigh") String GHigh,
                               @RequestParam(value = "incallsLow") String incallsLow,
                               @RequestParam(value = "incallsHigh") String incallsHigh,
                               @RequestParam(value = "outcallsLow") String outcallsLow,
                               @RequestParam(value = "outcallsHigh") String outcallsHigh,
                               @RequestParam(value = "vk", required = false) String vk,
                               @RequestParam(value = "fb", required = false) String fb,
                               @RequestParam(value = "ok", required = false) String ok,
                               @RequestParam(value = "tw", required = false) String tw,
                               @RequestParam(value = "smsLow") String smsLow,
                               @RequestParam(value = "smsHigh") String smsHigh) {
        ArrayList<Tariff> result = new ArrayList<>();
        for (Tariff t : tariffDAO.findAllTariff()) {
            //---------------------------------------------------------------------------------------
            if (!GLow.equals("") && !GHigh.equals("")) {
                if (Integer.valueOf(t.getParameters().get(1).getValue()) < Integer.valueOf(GLow)
                        || Integer.valueOf(t.getParameters().get(1).getValue()) > Integer.valueOf(GHigh)) {
                    continue;
                }
            }
            if (!GLow.equals("") && GHigh.equals("")) {
                if (Integer.valueOf(t.getParameters().get(1).getValue()) < Integer.valueOf(GLow)) {
                    continue;
                }
            }
            if (GLow.equals("") && !GHigh.equals("")) {
                if (Integer.valueOf(t.getParameters().get(1).getValue()) > Integer.valueOf(GHigh)) {
                    continue;
                }
            }
            //---------------------------------------------------------------------------------------
            if (!incallsLow.equals("") && !incallsHigh.equals("")) {
                if (Integer.valueOf(t.getParameters().get(2).getValue()) < Integer.valueOf(incallsLow)
                        || Integer.valueOf(t.getParameters().get(2).getValue()) > Integer.valueOf(incallsHigh)) {
                    continue;
                }
            }
            if (!incallsLow.equals("") && incallsHigh.equals("")) {
                if (Integer.valueOf(t.getParameters().get(2).getValue()) < Integer.valueOf(incallsLow)) {
                    continue;
                }
            }
            if (incallsLow.equals("") && !incallsHigh.equals("")) {
                if (Integer.valueOf(t.getParameters().get(2).getValue()) > Integer.valueOf(incallsHigh)) {
                    continue;
                }
            }
            //---------------------------------------------------------------------------------------
            if (!outcallsHigh.equals("") && !outcallsLow.equals("")) {
                if (Integer.valueOf(t.getParameters().get(3).getValue()) < Integer.valueOf(outcallsLow)
                        || Integer.valueOf(t.getParameters().get(3).getValue()) > Integer.valueOf(outcallsHigh)) {
                    continue;
                }
            }
            if (!outcallsLow.equals("") && outcallsHigh.equals("")) {
                if (Integer.valueOf(t.getParameters().get(3).getValue()) < Integer.valueOf(outcallsLow)) {
                    continue;
                }
            }
            if (outcallsLow.equals("") && !outcallsHigh.equals("")) {
                if (Integer.valueOf(t.getParameters().get(3).getValue()) > Integer.valueOf(outcallsHigh)) {
                    continue;
                }
            }
            //---------------------------------------------------------------------------------------
            if (Boolean.valueOf(vk)) {
                if (!t.getParameters().get(4).getValue().contains("VK") && !t.getParameters().get(4).getValue().equals("Все")) {
                    continue;
                }
            }
            if (Boolean.valueOf(fb)) {
                if (!t.getParameters().get(4).getValue().contains("Facebook") && !t.getParameters().get(4).getValue().equals("Все")) {
                    continue;
                }
            }
            if (Boolean.valueOf(ok)) {
                if (!t.getParameters().get(4).getValue().contains("OK") && !t.getParameters().get(4).getValue().equals("Все")) {
                    continue;
                }
            }
            if (Boolean.valueOf(tw)) {
                if (!t.getParameters().get(4).getValue().contains("Twitter") && !t.getParameters().get(4).getValue().equals("Все")) {
                    continue;
                }
            }
            //---------------------------------------------------------------------------------------
            if (!smsLow.equals("") && !smsHigh.equals("")) {
                if (Integer.valueOf(t.getParameters().get(5).getValue()) < Integer.valueOf(smsLow)
                        || Integer.valueOf(t.getParameters().get(5).getValue()) > Integer.valueOf(smsHigh)) {
                    continue;
                }
            }
            if (!smsLow.equals("") && smsHigh.equals("")) {
                if (Integer.valueOf(t.getParameters().get(5).getValue()) < Integer.valueOf(smsLow)) {
                    continue;
                }
            }
            if (smsLow.equals("") && !smsHigh.equals("")) {
                if (Integer.valueOf(t.getParameters().get(5).getValue()) > Integer.valueOf(smsHigh)) {
                    continue;
                }
            }
            result.add(t);
        }
        ModelAndView model = new ModelAndView("tariffs");
        model.addObject("tariffs", result);
        return model;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin() {
        if (httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        ModelAndView model = new ModelAndView("signin");
        return model;
    }


    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public ModelAndView feedback() {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        ModelAndView model = new ModelAndView("feedback");
        return model;
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public ModelAndView postFeedback(@RequestParam(value = "text") String text) {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        Sender sender = new Sender("TariffObSys@gmail.com", "#af45Ecsrg67&");
        sender.send("Отзыв от " + userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getUsername(), text, "TOS Command", "TariffObSys@gmail.com");
        userDAO.incrementFeedbackSent((int) httpSession.getAttribute(CURRENT_ID_PARAM));
        ModelAndView model = new ModelAndView("redirect:/");
        return model;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView signinPOST(@RequestParam("username") String username, @RequestParam("password") String password) {
        if (httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        if (userDAO.findByUsername(username) != null) {
            if (DigestUtils.md5DigestAsHex(password.getBytes()).
                    equals(userDAO.findByUsername(username).getPassword()) && userDAO.findByUsername(username).isBanned() == false) {
                httpSession.setAttribute(CURRENT_ID_PARAM, userDAO.findByUsername(username).getId());
                ModelAndView model = new ModelAndView("redirect:/");
                return model;
            } else if (userDAO.findByUsername(username).isBanned()) {
                ModelAndView model = new ModelAndView("signin");
                model.addObject("error", "Ваш аккаунт заблокирован.");
                return model;
            }
        }
        ModelAndView model = new ModelAndView("signin");
        model.addObject("error", "Wrong username or password");
        return model;
    }

    @RequestMapping(value = "/profile")
    public ModelAndView userExplore() {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/signin");
            return model;
        }
        ModelAndView model = new ModelAndView("user");
        model.addObject("user", userDAO.findUser((Integer) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0));
        return model;
    }

    @RequestMapping(value = "/changeUser")
    public ModelAndView changeUser() {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        ModelAndView model = new ModelAndView("changeUser");
        User currentUser = userDAO.findUser((Integer) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0);
        model.addObject("user", currentUser);
        return model;
    }

    @RequestMapping(value = "/compare", method = RequestMethod.POST)
    public ModelAndView compare(@RequestParam(value = "firstTariffId") int firstTariffId, @RequestParam(value = "secondTariffId") int secondTariffId){
        ModelAndView model = new ModelAndView("compare");
        model.addObject("firstTariff", tariffDAO.findTariff(firstTariffId).get(0));
        model.addObject("secondTariff", tariffDAO.findTariff(secondTariffId).get(0));
        return model;
    }

    @RequestMapping(value = "/changeUser", method = RequestMethod.POST)
    public ModelAndView changeUserPOST(@RequestParam("username") String username, @RequestParam("name") String name,
                                       @RequestParam("surname") String surname) {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        User currentUser = userDAO.findUser((Integer) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0);
        if (username.equals("") || name.equals("") || surname.equals("")) {
            ModelAndView model = new ModelAndView("changeUser");
            model.addObject("error", "You must enter all parameters");
            model.addObject("user", userDAO.findUser((Integer) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0));
            return model;
        }
        if (userDAO.findByUsername(username) == null || userDAO.findByUsername(username)
                .getUsername().equals(currentUser.getUsername())) {
            currentUser.setUsername(username);
            currentUser.setName(name);
            currentUser.setSurname(surname);
            userDAO.updateUserData(userDAO.findUser((Integer) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getId(), currentUser);
            ModelAndView model = new ModelAndView("redirect:profile");
            model.addObject("user", currentUser);
            return model;
        } else {
            ModelAndView model = new ModelAndView("changeUser");
            model.addObject("error", "Username is already exist.");
            model.addObject("user", userDAO.findUser((Integer) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0));
            return model;
        }

    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute(value = "query") String query) {
        List<Telephone> telephones = telephoneDAO.findUndeleted();
        List<Telephone> result = new ArrayList<>();
        for (Telephone t : telephones) {
            if (t.getNumber().contains(query)) {
                result.add(t);
            }
        }
        ModelAndView model = new ModelAndView("telephone");
        model.addObject("results", result);
        return model;

    }

    @RequestMapping(value = "/changePassword")
    public ModelAndView changePassword() {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        return new ModelAndView("changePassword");
    }

    @RequestMapping(value = "/changePassword", method = RequestMethod.POST)
    public ModelAndView changePasswordPOST(@RequestParam("oldpassword") String oldpassword, @RequestParam("password") String password,
                                           @RequestParam("repassword") String repassword) {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        User currentUser = userDAO.findUser((Integer) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0);
        if (currentUser.getPassword().equals(DigestUtils.md5DigestAsHex(oldpassword.getBytes()))) {
            if (password.equals(repassword)) {
                currentUser.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
                userDAO.updateUserPass(currentUser.getId(), currentUser);
                ModelAndView model = new ModelAndView("redirect:profile");
                model.addObject("user", currentUser);
                return model;
            } else {
                ModelAndView model = new ModelAndView("changePassword");
                model.addObject("error", "Passwords do not match");
                return model;
            }
        } else {
            ModelAndView model = new ModelAndView("changePassword");
            model.addObject("error", "Wrong old password");
            return model;
        }
    }

    @RequestMapping(value = "activate", method = RequestMethod.GET)
    public ModelAndView activate() {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        User currentUser = userDAO.findUser((Integer) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0);
        ModelAndView model = new ModelAndView("activate");
        model.addObject("mail", Validator.createLinkToEmail(currentUser.getMail()));
        return model;
    }

    @RequestMapping(value = "activate", method = RequestMethod.POST)
    public ModelAndView activate(@RequestParam("code") String code) {
        if (!httpSession.getAttributeNames().hasMoreElements()) {
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        }
        User currentUser = userDAO.findUser((Integer) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0);
        if (currentUser.getActivated().equals(code)) {
            currentUser.setActivated(null);
            userDAO.updateActivated(currentUser.getId(), currentUser);
            ModelAndView model = new ModelAndView("redirect:/");
            return model;
        } else {
            ModelAndView model = new ModelAndView("redirect:activate");
            model.addObject("error", "Неверный код активации.");
            return model;
        }

    }

    @RequestMapping(value = "/adminPanel")
    public ModelAndView adminPanel() {
        if (httpSession.getAttributeNames().hasMoreElements() && userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
            ModelAndView model = new ModelAndView("adminPanel");
            model.addObject("tariffs", tariffDAO.findUndeleted());
            model.addObject("telephones", telephoneDAO.findUndeleted());
            return model;
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteTariff", method = RequestMethod.POST)
    public ModelAndView deleteTariff(@RequestParam(value = "tariffId") String tariffId) {
        if (httpSession.getAttributeNames().hasMoreElements() && userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
            ModelAndView model = new ModelAndView("redirect:/adminPanel");
            tariffDAO.deleteTariff(Integer.valueOf(tariffId));
            return model;
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteTelephone", method = RequestMethod.POST)
    public ModelAndView deleteTelephone(@RequestParam(value = "telephone") String telephone) {
        if (httpSession.getAttributeNames().hasMoreElements() && userDAO.findUser((int) httpSession.getAttribute(CURRENT_ID_PARAM)).get(0).getRole().getId() == 2) {
            ModelAndView model = new ModelAndView("redirect:/adminPanel");
            if (telephoneDAO.findByTelephone(telephone) != null) {
                telephoneDAO.deleteTelephone(telephoneDAO.findByTelephone(telephone).getId());
            }
            return model;
        }
        return new ModelAndView("redirect:/");
    }

}
