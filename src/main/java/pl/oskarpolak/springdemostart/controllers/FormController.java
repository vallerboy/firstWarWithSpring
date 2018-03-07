package pl.oskarpolak.springdemostart.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.oskarpolak.springdemostart.models.RegisterForm;

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
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("registerForm") RegisterForm registerForm,
                               Model model){
        model.addAttribute("isValidRegister",
                registerForm.getPassword().equals(registerForm.getPasswordRepeat()));
        return "register";
    }

}
