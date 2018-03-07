package pl.oskarpolak.springdemostart.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class FormController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String loginPost(@RequestParam("login") String login,
                            @RequestParam("password") String password){
        if(login.equals("oskar") && password.equals("123")) {
            return "Zalogowno!";
        }
        return "Błędne dane";
    }


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String registerPost(@PathVariable("login") String login,
                               @PathVariable("password") String password,
                               @PathVariable("passwordRepeat") String passwordRepeat,
                               @PathVariable("email") String email){
        if(password.equals(passwordRepeat)){
            return "Rejestracja przebiegla pomyslnie";
        }else{
            return "Hasła musza byc takie same";
        }
    }

}
