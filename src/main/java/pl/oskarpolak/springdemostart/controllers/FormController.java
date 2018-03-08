package pl.oskarpolak.springdemostart.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
        RegisterForm registerForm =  new RegisterForm();
        registerForm.setEmail("test@test.pl");
        model.addAttribute("registerForm", registerForm);
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@ModelAttribute("registerForm") RegisterForm registerForm,
                               BindingResult bindingResult,
                               Model model){
        if(bindingResult.hasErrors()){
            return "register";
        }

        model.addAttribute("isValidRegister",
                registerForm.getPassword().equals(registerForm.getPasswordRepeat()));
        return "register";
    }

}
