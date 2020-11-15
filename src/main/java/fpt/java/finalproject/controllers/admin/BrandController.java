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

import fpt.java.finalproject.models.Brand;
import fpt.java.finalproject.response.AdminListResponse;
import fpt.java.finalproject.response.AdminObjectResponse;
import fpt.java.finalproject.response.AdminResponse;
import fpt.java.finalproject.services.BrandService;

@RequestMapping("/admin/brands")
@Controller
public class BrandController {

    @Autowired
    BrandService brandService;

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m) {

        AdminObjectResponse<Brand> res = new AdminObjectResponse<>();
        Brand b = new Brand();

        res.setTitle("Thêm nhãn hàng");

        // Send new response bean
        m.addAttribute("object", b);
        m.addAttribute("res", res);

        return "admin/brands/add_or_edit";
    }

    // Save new
    @PostMapping("/save")
    public String save(Brand b, ModelMap m) {

        AdminResponse res = new AdminResponse();

        // Save brand
        try {
            brandService.save(b);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setMessage("Lưu thành công!");

        // Send response
        m.addAttribute("res", res);

        // Redirect to list page
        return "redirect:/admin/brands";
    }

    // Direct to edit page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminObjectResponse<Brand> res = new AdminObjectResponse<>();
        Brand b = new Brand();

        // Find brand
        try {
            b = brandService.findById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setIsEdit(true);
        res.setTitle("Cập nhật thông tin");

        // Send response
        m.addAttribute("res", res);
        m.addAttribute("object", b);
        return "admin/brands/add_or_edit";
    }

    // List
    @GetMapping("")
    public String list(ModelMap m) {

        AdminResponse obj = (AdminResponse) m.getAttribute("res");
        AdminListResponse<Brand> res = new AdminListResponse<>();
        if (obj == null) {
            res = new AdminListResponse<>();
        } else {
            res.setNewResponse(obj);
        }

        List<Brand> l;
        try {
            l = brandService.findAll();
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        try {
            // res.generateResponse(l, 0, 0,);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }
        res.setTitle("Danh sách nhãn hàng");

        // Send response
        m.addAttribute("res", res);
        return "admin/brands/list";
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") Integer id, ModelMap m) {

        AdminResponse res = new AdminResponse();

        // Find brand
        try {
            brandService.deleteById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setTitle("Xóa nhãn hàng thành công");

        // Send response
        m.addAttribute("res", res);

        return "redirect:/admin/brands";
    }
}
