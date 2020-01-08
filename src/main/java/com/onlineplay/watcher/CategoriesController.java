package com.onlineplay.watcher;

import com.onlineplay.watcher.entity.Categories;
import com.onlineplay.watcher.repository.CategoriesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/categories")
public class CategoriesController {

    @Autowired
    private CategoriesRepository categoriesRepository;

    @RequestMapping("/category")
    public String getCategoryByID(Model model) {
        List<Categories> categories = categoriesRepository.findAll();
        model.addAttribute("listCategories", categories);
        return "common/header";
    }
}
