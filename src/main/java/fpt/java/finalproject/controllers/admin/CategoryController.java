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

import fpt.java.finalproject.models.Category;
import fpt.java.finalproject.response.ListResponse;
import fpt.java.finalproject.response.ObjectResponse;
import fpt.java.finalproject.response.Response;
import fpt.java.finalproject.services.CategoryService;

@RequestMapping("/admin/categories")
@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    // Direct to add page
    @GetMapping("/add")
    public String add(ModelMap m) {

        ObjectResponse<Category> res = new ObjectResponse<>();
        res.setTitle("Thêm danh mục");

        // Send new response bean
        m.addAttribute("res", res);

        return "admin/categories/add_or_edit";
    }

    // Save new
    @PostMapping("/save")
    public String save(Category c, ModelMap m) {

        Response res = new Response();

        // Save category
        try {
            categoryService.save(c);
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
        return "redirect:/admin/categories";
    }

    // Direct to edit page
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id, ModelMap m) {

        ObjectResponse<Category> res = new ObjectResponse<>();
        Category c = new Category();

        // Find category
        try {
            c = categoryService.findById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setObject(c);
        res.setIsEdit(true);
        res.setTitle("Cập nhật thông tin");

        // Send response
        m.addAttribute("res", res);

        return "admin/categories/add_or_edit";
    }

    // List
    @GetMapping("")
    public String list(ModelMap m) {

        Response obj = (Response) m.getAttribute("res");
        ListResponse<Category> res = new ListResponse<>();
        if (obj == null) {
            res = new ListResponse<>();
        } else {
            res.setNewResponse(obj);
            ;
        }

        List<Category> l;
        try {
            l = categoryService.findAll();
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

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
        res.setTitle("Danh sách danh mục");

        // Send response
        m.addAttribute("res", res);
        return "admin/categories/list";
    }

    // Delete
    @DeleteMapping("/{id}")
    public String delete(@PathVariable(name = "id") Integer id, ModelMap m) {

        Response res = new Response();

        // Find category
        try {
            categoryService.deleteById(id);
        } catch (Exception ex) {
            // Return error on fail
            res.setIsError(true);
            res.setMessage(ex.getMessage());
            m.addAttribute("res", res);
            return "module/error";
        }

        // Set response
        res.setTitle("Xóa danh mục thành công");

        // Send response
        m.addAttribute("res", res);

        return "redirect:/admin/categories";
    }
}
