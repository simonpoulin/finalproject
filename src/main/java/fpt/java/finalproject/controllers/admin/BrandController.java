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
import fpt.java.finalproject.response.BrandResponse;
import fpt.java.finalproject.services.BrandService;

@RequestMapping("/admin/brands")
@Controller
public class BrandController {

    BrandResponse res;

    @Autowired
    BrandService brandService;

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m) {

        res = new BrandResponse();
        res.setTitle("Thêm nhãn hàng");

        // Send new response bean
        m.addAttribute("res", res);

        return "admin/brands/add_or_edit";
    }

    // Save new
    @PostMapping("/save")
    public String save(Brand b, ModelMap m) {

        res = new BrandResponse();

        // Save brand
        try {
            brandService.save(b);
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
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

        res = new BrandResponse();
        Brand b = new Brand();

        // Find brand
        try {
            b = brandService.findById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setBrand(b);
        res.setIsEdit(true);
        res.setTitle("Cập nhật thông tin");

        // Send response
        m.addAttribute("res", res);

        return "admin/brands/add_or_edit";
    }

    // List
    @GetMapping("")
    public String list(ModelMap m) {

        Object obj = m.getAttribute("res");
        List<Brand> l;

        if (obj == null) {
            res = new BrandResponse();
        } else {
            res = (BrandResponse) obj;
        }

        try {
            l = brandService.findAll();
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setBrandList(l);
        res.setIsEdit(true);
        res.setTitle("Danh sách nhãn hàng");

        // Send response
        m.addAttribute("res", res);
        return "admin/brands/list";
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") Integer id, ModelMap m) {

        res = new BrandResponse();

        // Find brand
        try {
            brandService.deleteById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setError(true);
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
