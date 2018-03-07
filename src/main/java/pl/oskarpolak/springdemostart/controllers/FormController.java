package pl.oskarpolak.springdemostart.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String registerPost(@RequestParam("login") String login,
                               @RequestParam("password") String password,
                               @RequestParam("passwordRepeat") String passwordRepeat,
                               @RequestParam("email") String email,
                               Model model){
        model.addAttribute("isValidRegister", password.equals(passwordRepeat));
        return "register";
    }

}
