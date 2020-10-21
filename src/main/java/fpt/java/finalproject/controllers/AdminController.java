package fpt.java.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @RequestMapping("/cha")
    public String cha() {
        return "test/layout.html";
    }

    @RequestMapping("/con")
    public String con() {
        return "test/giao_dien.html";
    }
}
