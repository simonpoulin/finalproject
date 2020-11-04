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
import fpt.java.finalproject.response.ProductResponse;
import fpt.java.finalproject.services.ProductService;

@Controller
@RequestMapping("product")
public class ProductController {

    private ProductResponse productResponse;
    
    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String add(ModelMap model){

        productResponse = new ProductResponse();
        productResponse.setTitle("Thêm cửa hàng");

        // Send new response bean
        model.addAttribute("res", productResponse);
        return "admin/products/add";
    }
    //end function add

    // save new
    @PostMapping("/save")
    public String save(ModelMap model, Product product){
        productResponse = new ProductResponse();

        //save new product
        try{
            productService.save(product);
        }catch(Exception ex){

            //return fail
            productResponse.setError(true);
            productResponse.setMessage(ex.getMessage());
            model.addAttribute("res", productResponse);
            return "module/error";
        }
        // end try catch

        //Set response
        productResponse.setMessage("Lưu thành công");

        //send response
        model.addAttribute("res", productResponse);

        // Redirect to list
        return "redirect:/admin/products";
    }
    // end function save

    // Direct to edit page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id, ModelMap model){

        productResponse = new ProductResponse();
        Product product = new Product();

        // Find by id product
        try{
            product = productService.findById(id);
        }catch(Exception ex){
             //return fail
             productResponse.setError(true);
             productResponse.setMessage(ex.getMessage());
             model.addAttribute("res", productResponse);
             return "module/error";
        }
        // end try catch
        
        // Set response
        productResponse.setProduct(product);
        productResponse.setEdit(true);
        productResponse.setTitle("cập nhật thông tin");

        // Send response
        model.addAttribute("res", productResponse);

        return "admin/products/add";
    }
    // end function edit

    // List
    @GetMapping("")
    public String list(ModelMap model){

        Object obj = model.addAttribute("res");
        List<Product> list;
        if(obj == null){
            productResponse = new ProductResponse();
        }else{
            productResponse = (ProductResponse) obj;
        }
        // end if else

        try {
            list = productService.findAll();
        } catch (Exception ex) {
           //return fail
           productResponse.setError(true);
           productResponse.setMessage(ex.getMessage());
           model.addAttribute("res", productResponse);
           return "module/error";
        }
        // end try catch

        // Set response
        productResponse.setProductList(list);
        productResponse.setEdit(true);
        productResponse.setTitle("Danh sách sản phẩm");

        // Send response
        model.addAttribute("res", productResponse);
        return "admin/products/list";
    }
    //end function list

    // Detail
    @GetMapping("/{id}")
    public String detail (@PathVariable(name ="id") Integer id, ModelMap model){

        productResponse = new ProductResponse();
        Product product = new Product();

        // Find by id
      try {
            product = productService.findById(id);
        } catch (Exception ex) {
            //return fail
            productResponse.setError(true);
            productResponse.setMessage(ex.getMessage());
            model.addAttribute("res", productResponse);
            return "module/error";
        }
        // end function try catch

        //Set response
        productResponse.setProduct(product);
        productResponse.setTitle("Thông tin sản phẩm");

        //Send response
        model.addAttribute("res", productResponse);
        return "admin/products/edit";
    }
    //end funcition detail

    //del
    @DeleteMapping("/{id}")
    public String del(@PathVariable(name = "id") Integer id,  ModelMap model){
        productResponse = new ProductResponse();

        // del by id
        try {
            productService.deleteById(id);
        } catch (Exception ex) {
            //return fail
            productResponse.setError(true);
            productResponse.setMessage(ex.getMessage());
            model.addAttribute("res", productResponse);
            return "module/error";
        }
        
        //Set Response
        productResponse.setTitle("Xóa sản phẩm");

        // send Response
        model.addAttribute("res", productResponse);

        return "redirect:/admin/products";
    }
}
