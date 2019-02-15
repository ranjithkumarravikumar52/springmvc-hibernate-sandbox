package customermodule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RequestMapping("")
@Controller
public class HelloController {
    @RequestMapping(method = RequestMethod.GET)
    public String showHome(Model model) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String current = dateFormat.format(date);
        model.addAttribute("currentTime", current);
        return "home";

    }
}
