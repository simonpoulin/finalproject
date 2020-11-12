package fpt.java.finalproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/")
    public String index() {
        return "test/index";
    }

    @GetMapping("/manager")
    public String manager() {
        return "test/manager";
    }

    @GetMapping("/admin")
    public String admin() {
        return "test/admin";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "test/403";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "test/login";
    }

   
}
