package pl.oskarpolak.springdemostart.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.oskarpolak.springdemostart.models.LoginForm;
import pl.oskarpolak.springdemostart.models.RegisterForm;
import pl.oskarpolak.springdemostart.models.UserService;

import javax.validation.Valid;

@Controller
public class FormController {

    @Autowired
    MessageSource messageSource;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        //System.out.println(messageSource.getMessage("test", new Object[]{}, Locale.getDefault()));
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String loginPost(@Valid @ModelAttribute("loginForm") LoginForm loginForm,
                            BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "Uzupełnij dane";
        }

        if(loginForm.getLogin().equals("oskar") && loginForm.getPassword().equals("123")) {
            userService.setLogin(true);
            return "Zalogowno!";
        }
        return "Błędne dane";
    }


    @GetMapping("/content")
    @ResponseBody
    public String someContent(){
        if(userService.isLogin()){
            return "To content dla wybrancow!";
        }
        //"redirect:/login"
        return "Musisz się pierwsze zalogować!";
    }

    @GetMapping("/logout")
    public String logout(){
        userService.setLogin(false);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        RegisterForm registerForm =  new RegisterForm();
        registerForm.setEmail("test@test.pl");
        model.addAttribute("registerForm", registerForm);
        return "register";
    }

    @PostMapping("/register")
    public String registerPost(@Valid @ModelAttribute("registerForm") RegisterForm registerForm,
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
