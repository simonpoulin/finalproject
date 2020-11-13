package fpt.java.finalproject.controllers.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpt.java.finalproject.models.Shop;
import fpt.java.finalproject.response.AdminListResponse;
import fpt.java.finalproject.response.AdminObjectResponse;
import fpt.java.finalproject.response.AdminResponse;
import fpt.java.finalproject.services.ShopService;

@Controller
@RequestMapping("/admin/shops")
public class ShopController{

    @Autowired
    private ShopService shopService;

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m){
        
        AdminObjectResponse<Shop> res = new AdminObjectResponse<Shop>();
        Shop s = new Shop();

        res.setTitle("Thêm cửa hàng");
        res.setIsEdit(false);

        // Send new response bean
        m.addAttribute("res", res);
        m.addAttribute("object", s);

        return "test/testAdd";
    }
    //end function add();

    // save new
    @PostMapping("/save")
    public String save(Shop s, ModelMap m){

        AdminResponse res = new AdminResponse();

        // save new shop
        try{
            shopService.save(s);
        }catch(Exception ex){
            
            //return fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        // end try catch

        // Set response 
        res.setMessage("Lưu thành công");

        // Send response
        m.addAttribute("res", res);

        // Redirect to list
        return "redirect:/test/testAdd";
    }

    // Direct to edit page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id, ModelMap m){

        AdminObjectResponse<Shop> res = new AdminObjectResponse<>();
        Shop s = new Shop();
        // Find by id Shop
        try{
            s = shopService.findById(id);
        }catch(Exception ex){
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        // end try catch

        // Set response
        res.setIsEdit(true);
        res.setTitle("Cập nhật thông tin");

        // Send response
        m.addAttribute("res", res);
        m.addAttribute("object", s);

        return "test/testAdd";
    }

    // List
    @GetMapping("")
    public String list(ModelMap m){

        Object obj = m.getAttribute("res");
        AdminListResponse<Shop> res = new AdminListResponse<>();
        if(obj == null){
            res = new AdminListResponse<>();
        }else{
            res.setNewResponse(res);
        }
        // end if else

        List<Shop> l;
        try{
            l = shopService.findAll();
        }catch(Exception ex){

            // Return erroe on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        // end try catch

        // Set response
        try {
            res.generateResponse(l, 0, 0);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        res.setTitle("Danh sách cửa hàng");

        // Send AdminResponse
        m.addAttribute("res", res);
        return "test/testList";
    }
    // End function list

    // Detail
    @GetMapping("detail/{id}")
    public String detail(@PathVariable(name ="id") Integer id, ModelMap m){

        Shop s = new Shop();
        AdminObjectResponse<Shop> res= new AdminObjectResponse<>();

        // Find Shop by id
        try{
            s = shopService.findById(id);
        }catch(Exception ex){
            // return error
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        // End try catch

        // Set response
        res.setObject(s);
        res.setTitle("Thông tin cửa hàng");

        // Send AdminResponse
        m.addAttribute("res", res);
        return "test/testObject";
    }
    //end function detail

    //Del
    @DeleteMapping("/{id}")
    public String del(@PathVariable(name = "id") Integer id, ModelMap m){

        AdminResponse res = new AdminResponse();

        // find shop by id
        try{
            shopService.deleteById(id);
        }catch(Exception ex){
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        // Set AdminResponse

        res.setTitle("Xóa cửa hàng");

        // send AdminResponse
        m.addAttribute("res", res);

        return "redirect:/admin/shops";

    }
}
