package fpt.java.finalproject.controllers.user;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fpt.java.finalproject.models.CartDetail;
import fpt.java.finalproject.services.CartDetailSevice;

@Controller
@SessionAttributes("cart")
public class CartController {
    
    @Autowired
    private CartDetailSevice cartDetailSevice;

    List<CartDetail> lC = new ArrayList<>();
    @GetMapping("/cart")
    public String cart(@ModelAttribute CartDetail c,HttpSession http){
        lC.add(c);
        http.setAttribute("cart", lC);
        List<CartDetail> list = (List<CartDetail>) http.getAttribute("cart");

        return "";
    }
}
