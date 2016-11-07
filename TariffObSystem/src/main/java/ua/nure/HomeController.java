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
        //m.addAttribute("value", "fromController");
        List<Tariff> empty = new ArrayList<>();
        ModelAndView model = new ModelAndView("index");
        model.addObject("tariffs", empty);
        model.addObject("count", db.tariffs.size());
        return model;
    }
    @RequestMapping(value = "/mainmenu")
    public String mainmenu(){
        return "mainmenu";
    }
}
