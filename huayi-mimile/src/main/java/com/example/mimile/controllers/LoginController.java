package com.example.mimile.controllers;


import com.example.mimile.beans.User;
import com.example.mimile.beans.UserLogin;
import com.example.mimile.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("userLogin",new UserLogin());
        return "login";
    }
    @PostMapping("/login")
    public String login(@Valid UserLogin user, BindingResult result, HttpSession session, Model model){
        if(result.hasErrors()){
            return "redirect:/login";
        }
        User u=userService.checkUser(user);
        if(u!=null){
            session.setAttribute("user",u);
            return "index";
        }
        model.addAttribute("fail","账号或密码不正确");
        return "redirect:/login";
    }

    @GetMapping("/index")
    public String index(){

        return "index";}
}

