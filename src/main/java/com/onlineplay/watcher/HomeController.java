/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onlineplay.watcher;

/**
 *
 * @author Anđelka
 */
import com.onlineplay.watcher.entity.Categories;
import com.onlineplay.watcher.service.CategoriesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    
    
//    @Autowired
//    private CategoriesService categoriesService;

    @GetMapping("index")
    public String index() {
        return "index";
    }

    @GetMapping("login")
    public String login() {
        return "login";
    }

    
    
   /* 
    @RequestMapping("/admin/allCategories")
    public String getViewCategories(Model model) {
        List<Categories> getCategories = categoriesService.listAll();
        model.addAttribute("categories", getCategories);
        return "admin_allCategories";
    }

    @RequestMapping("/admin/newCategory")
    public String addCategory (Model model) {
        Categories theCategory = new Categories();
        model.addAttribute("categories", theCategory);
        return "admin_newCategories";
    }

    @RequestMapping(value = "saveCategory", method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category") Categories theCategory) {
        categoriesService.saveCategories(theCategory);
        return "redirect:/admin/allCategories";
    }

    @RequestMapping("/admin/editCategory/{id_category}")
    public ModelAndView showEditCategoryForm(@PathVariable(name = "id_category") int id_category) {
        ModelAndView mav = new ModelAndView("admin_editCategories");
        Categories theCategory = categoriesService.get(id_category);
        mav.addObject("category", theCategory);
        return mav;
    }

    @RequestMapping("/admin/deleteCategory/{id_category}")
    public String deletePredmet(@PathVariable(name = "id_category") int id_category) {

        categoriesService.delete(id_category);

        return "redirect:/admin/allCategories";
    }
*/
}
