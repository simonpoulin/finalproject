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

import fpt.java.finalproject.models.ShopItem;
import fpt.java.finalproject.response.ListResponse;
import fpt.java.finalproject.response.ObjectResponse;
import fpt.java.finalproject.response.Response;
import fpt.java.finalproject.services.ShopItemService;

@Controller
@RequestMapping("/admin/shopitems")
public class ShopItemController {
    
    @Autowired
    private ShopItemService shopItemService;

    @GetMapping("/add")
    public String add(ModelMap m){
        
        ObjectResponse<ShopItem> res = new ObjectResponse<ShopItem>();
        ShopItem sI = new ShopItem();

        res.setTitle("Thêm Mặt Hàng");

        // Send new response bean
        m.addAttribute("res", res);
        m.addAttribute("object", sI);

        return "admin/shopitems/add";
    }
    //end function add

    // save new
    @PostMapping("/save")
    public String save(ModelMap m, ShopItem sI){

        Response res = new Response();

        // save new shopitem
        try {
            shopItemService.save(sI);
        } catch (Exception ex) {
           
            // Return fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        //end try catch

        // Set response
        res.setMessage("Lưu thành công");

        //send response
        m.addAttribute("res", res);

        // Redirect to list
        return "redirect:/admin/shopitems";
    }
    // end function save

    // edit
    @GetMapping("/edit/{id}")
    public String edit(ModelMap m, @PathVariable(name = "id") Integer id){

        ObjectResponse<ShopItem> res = new ObjectResponse<>();
        ShopItem sI = new ShopItem();

        //find by id shopitem
        try {
            sI = shopItemService.findById(id);
        } catch (Exception ex) {
           // Return fail
           res.setIsError(true);
           res.setMessage(ex.getMessage());
           m.addAttribute("res", res);
           return "module/error";
        }
        // end try catch

        // Set response
        res.setIsEdit(true);
        res.setTitle("cập nhật thành công");

        // Send response
        m.addAttribute("res", res);
        m.addAttribute("object", sI);

        return "admin/shopitems/add";
    }
    // end function edit

    //List
    @GetMapping("")
    public String list(ModelMap m){


        Object obj = m.addAttribute("res");
        List<ShopItem> l;
        ListResponse<ShopItem> res = new ListResponse<>();
        if(obj == null){
            res = new ListResponse<>();
        }else{
            res.setNewResponse(res);
        }
        // end if else

        try {
            l = shopItemService.findAll();
        } catch (Exception ex) {
            // Return fail
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
        res.setTitle("Danh sách mặt hàng");

        // send response
        m.addAttribute("res", res);
        return "test/testList";
    }
    // end function list

    // Detail
    @GetMapping("/{id}")
    public String detail(@PathVariable(name ="id") Integer id, ModelMap m){

        ObjectResponse<ShopItem> res = new ObjectResponse<>();
        ShopItem sI = new ShopItem();

        // Find by id
        try {
            sI = shopItemService.findById(id);
        } catch (Exception ex) {
           // Return fail
           res.setIsError(true);
           res.setMessage(ex.getMessage());
           m.addAttribute("res", res);
           return "module/error";
        }
        // end function try catch

        // Set response
        res.setObject(sI);
        res.setTitle("Thông tin mặt hàng");

        // send response
        m.addAttribute("res", res);
        return "admin/shopitems/add";
    }
    // End function detail

    //del
    @DeleteMapping("/{id}")
    public String del(@PathVariable(name = "id") Integer id, ModelMap m){

        Response res = new Response();

        //dell by id
        try {
            shopItemService.deleteById(id);
        } catch (Exception ex) {
           // Return fail
           res.setIsError(true);
           res.setMessage(ex.getMessage());
           m.addAttribute("res", res);
           return "module/error";
        }
        // Set response
        res.setTitle("Xóa mặt hàng");

        // send response
        m.addAttribute("res", res);

        return "redirect:/admin/shopitems";
    }
}
