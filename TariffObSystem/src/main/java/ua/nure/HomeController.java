package ua.nure;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.nure.entities.DBImitator;
import ua.nure.entities.EmulateDB;
import ua.nure.entities.Tariff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Александр Доротенко on 06.11.2016.
 */
@Controller
public class HomeController {

    DBImitator db = EmulateDB.init();
    @RequestMapping(value = "/")
    public ModelAndView index(){
        ModelAndView model = new ModelAndView("index");
        return model;
    }
    @RequestMapping(value = "/mainmenu")
    public String mainmenu(){
        return "mainmenu";
    }

    @RequestMapping(value = "tariffs")
    public ModelAndView tariffs(){
        ModelAndView model = new ModelAndView("tariffs");
        model.addObject("tariffs", db.tariffs);
        return model;
    }
}
