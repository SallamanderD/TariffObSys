package ua.nure;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Александр Доротенко on 06.11.2016.
 */
@Controller
public class HomeController {
    @RequestMapping(value = "/")
    public String index(Model m){
        m.addAttribute("value", "из контроллера");
        return "index";
    }
}
