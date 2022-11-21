package br.atos.zoologico.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LoginController {

        @GetMapping("/login")
        public String login() {
            return "login";
         }
    @PostMapping("/login_success_handler")
    public String loginSuccessHandler() {
        //perform audit action
        return "/";
    }

    @PostMapping("/login_failure_handler")
    public String loginFailureHandler() {
        //perform audit action
        return "login";
    }

    @GetMapping("/login-error")
    public ModelAndView loginError() {
        String errorMessage = "Usuário ou Senha Incorretos!";
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("errorMessage", errorMessage);//ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}
