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

import fpt.java.finalproject.models.Product;
import fpt.java.finalproject.response.AdminListResponse;
import fpt.java.finalproject.response.AdminObjectResponse;
import fpt.java.finalproject.response.AdminResponse;
import fpt.java.finalproject.services.ProductService;

@Controller
@RequestMapping("/admin/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String add(ModelMap m){

        AdminObjectResponse<Product> res = new AdminObjectResponse<Product>();
        Product p = new Product();

        res.setTitle("Thêm sản phẩm");
        res.setIsEdit(false);

        // Send new response bean
        m.addAttribute("res", res);
        m.addAttribute("object", p);

        return "admin/products/add";
    }
    //end function add

    // save new
    @PostMapping("/save")
    public String save(ModelMap m, Product p){

        AdminResponse res = new AdminResponse();

        //save new product
        try{
            productService.save(p);
        }catch(Exception ex){

            //return fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        // end try catch

        //Set response
        res.setMessage("Lưu thành công");

        //send response
        m.addAttribute("res", res);

        // Redirect to list
        return "redirect:/admin/products";
    }
    // end function save

    // Direct to edit page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id, ModelMap m){

        AdminObjectResponse<Product> res = new AdminObjectResponse<>();
        Product p = new Product();

        // Find by id product
        try{
            p = productService.findById(id);
        }catch(Exception ex){
             //return fail
             res.setIsError(true);
             res.setMessage(ex.getMessage());
             m.addAttribute("res", p);
             return "module/error";
        }
        // end try catch
        
        // Set response
        res.setIsEdit(true);
        res.setTitle("cập nhật thông tin");

        // Send response
        m.addAttribute("res", res);
        m.addAttribute("object", p);

        return "admin/products/add";
    }
    // end function edit

    // List
    @GetMapping("")
    public String list(ModelMap m){

        Object obj = m.addAttribute("res");
        AdminListResponse<Product> res = new AdminListResponse<>();
        List<Product> l;
        if(obj == null){
            res = new AdminListResponse<>();
        }else{
            res.setNewResponse(res);
        }
        // end if else

        try {
            l = productService.findAll();
        } catch (Exception ex) {
           //return fail
           res.setIsError(true);
           res.setMessage(ex.getMessage());
           m.addAttribute("res", res);
           return "module/error";
        }
        // end try catch

        // Set response
        try {
            // res.generateResponse(l, 0, 0);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        res.setTitle("Danh sách sản phẩm");

        // Send response
        m.addAttribute("res", res);
        return "test/testList";
    }
    //end function list

    // Detail
    @GetMapping("/{id}")
    public String detail (@PathVariable(name ="id") Integer id, ModelMap m){

        Product p = new Product();
        AdminObjectResponse<Product> res = new AdminObjectResponse<>();

        // Find by id
      try {
            p = productService.findById(id);
        } catch (Exception ex) {
            //return fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        // end function try catch

        //Set response
        res.setObject(p);
        res.setTitle("Thông tin sản phẩm");

        //Send response
        m.addAttribute("res", res);
        return "admin/products/edit";
    }
    //end funcition detail

    //del
    @DeleteMapping("/{id}")
    public String del(@PathVariable(name = "id") Integer id,  ModelMap m){

        AdminResponse res = new AdminResponse();

        // del by id
        try {
            productService.deleteById(id);
        } catch (Exception ex) {
            //return fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        
        //Set AdminResponse
        res.setTitle("Xóa sản phẩm");

        // send AdminResponse
        m.addAttribute("res", res);

        return "redirect:/admin/products";
    }
}
