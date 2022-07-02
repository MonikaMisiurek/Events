package com.example.serwisagregujacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AboutController {

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

}
