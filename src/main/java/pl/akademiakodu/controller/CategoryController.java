package pl.akademiakodu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.data.CategoryRepository;
import pl.akademiakodu.data.GifRepository;
import pl.akademiakodu.model.Category;
import pl.akademiakodu.model.Gif;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GifRepository gifRepository;

    @RequestMapping("/categories")
    public String listCategories(ModelMap modelMap) {
        List<Category> categories = categoryRepository.getAllCategories();
        modelMap.put("categories", categories);
        return "categories";
    }
    @RequestMapping("/category/{id}")
    public String gifCategories(@PathVariable int id, ModelMap modelMap) {
        Category category = categoryRepository.findById(id);
        List<Gif> gifList = gifRepository.getByCategories(id);
        modelMap.put("category", category);
        modelMap.put("gifs", gifList);
        return "category";
    }
}