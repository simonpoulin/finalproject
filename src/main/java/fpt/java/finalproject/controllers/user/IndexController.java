package fpt.java.finalproject.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.java.finalproject.models.ShopItem;
import fpt.java.finalproject.services.ShopItemService;

@Controller
public class IndexController {
    
    @Autowired
    private ShopItemService shopService;
    
    @RequestMapping("/index")
    public String index(ModelMap m){

       m.put("list", shopService.findAll());

       return "user/layouts/index";
    }

    @GetMapping(value="/detail/{id}")
    public String detail(@PathVariable(name = "id") Integer id, ModelMap m) {

        ShopItem s = new ShopItem();

        try{
            s = shopService.findById(id);
        }catch(Exception e){
            e.printStackTrace();
        }
        m.addAttribute("object", s);
        return "user/layouts/item_details";
    }
    
}
