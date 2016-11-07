package ua.nure;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.entities.DBImitator;
import ua.nure.entities.EmulateDB;
import ua.nure.entities.Tariff;
import ua.nure.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр Доротенко on 06.11.2016.
 */
@Controller
public class HomeController {

    DBImitator db = EmulateDB.init();
    User currentUser = null;
    @RequestMapping(value = "/")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        return model;
    }
    @RequestMapping(value = "/mainmenu")
    public ModelAndView mainmenu(){
        ModelAndView model = new ModelAndView("mainmenu");
        model.addObject("user", currentUser);
        return model;
    }

    @RequestMapping(value = "tariffs")
    public ModelAndView tariffs(){
        ModelAndView model = new ModelAndView("tariffs");
        model.addObject("tariffs", db.tariffs);
        return model;
    }
    @RequestMapping(value = "/register")
    public ModelAndView register(){
        ModelAndView model = new ModelAndView("register");

        return model;
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signup(@RequestParam("username") String username, @RequestParam("password") String password){

        for(User u : db.users){
            if(u.getUsername().equals(username)){
                ModelAndView model = new ModelAndView("register");
                model.addObject("error", "Username is already exist");
                return model;
            }
        }
        ModelAndView model = new ModelAndView("index");
        User usr = new User(username, password);
        usr.setId(db.users.size() + 1);
        usr.role = db.roles.get(1);
        db.users.add(usr);
        currentUser = usr;
        return model;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView logout(){
        currentUser = null;
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public ModelAndView signin(){
        ModelAndView model = new ModelAndView("signin");
        return model;
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ModelAndView signinPOST(@RequestParam("username") String username, @RequestParam("password") String password){
        for(User u : db.users){
            if(u.getUsername().equals(username) && u.getPassword().equals(password)){
                currentUser = u;
                ModelAndView model = new ModelAndView("index");
                return model;
            }
        }
        ModelAndView model = new ModelAndView("signin");
        model.addObject("error", "Wrong username or password");
        return model;
    }
}
