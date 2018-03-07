package pl.oskarpolak.springdemostart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.regex.Pattern;

@Controller
public class MainController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String info(){
        return "info";
    }

    @RequestMapping(value = "/check/{age}/{name}", method = RequestMethod.GET)
    @ResponseBody
    public String check(@PathVariable(value = "age", required = false) Integer age,
                        @PathVariable(value = "name", required = false) String name){
        String pattern = "[0-9]{2}-[0-9]{3}";//Kod pocztowy
        return age >= 18 ? "Witaj w klubie " + name : "Uuu, wieczorynka czeka " + name;
    }

    @RequestMapping(value = "/zipCheck/{zip}", method = RequestMethod.GET)
    public String check(@PathVariable(value = "zip") String zip, Model model){
        String pattern = "[0-9]{2}-[0-9]{3}";//Kod pocztowy

        model.addAttribute("color", "red");
        model.addAttribute("isValid", Pattern.matches(pattern, zip));
        return "checker";
    }
}
