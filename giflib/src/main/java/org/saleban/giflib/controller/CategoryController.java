package org.saleban.giflib.controller;

import lombok.extern.slf4j.Slf4j;
import org.saleban.giflib.model.Category;
import org.saleban.giflib.model.Gif;
import org.saleban.giflib.utils.Mappings;
import org.saleban.giflib.utils.ViewNames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class CategoryController {
//    @Autowired
//    private CategoryRepository categoryRepository;
//    @Autowired
//    private GifRespository gifRespository;

    @GetMapping(Mappings.CATEGORIES)
    public ModelAndView categories(){
        ModelAndView mv = new ModelAndView(ViewNames.CATEGORIES);
        List<Category> categories = new ArrayList<>();
        mv.addObject("categories", categories);
        return mv;
    }

    @RequestMapping(Mappings.CATEGORY)
    public ModelAndView category(@RequestParam("id") int id){
        log.info("Category method is called {}");
        ModelAndView mv = new ModelAndView(ViewNames.CATEGORY);
//        Category category = categoryRepository.findById(id);
//        mv.addObject("category", category);
//        List<Gif> gifs = gifRespository.findByCategoryId(id);
//        mv.addObject("gifs", gifs);
        Category category = null;
        mv.addObject("category", category);
        return mv;
    }

//    // Get all favorites gif
//    @RequestMapping(Mappings.FAVORITE)
//    public ModelAndView favorite(){
//        // 1 is for favorite gif and 0 is un-favorite
//        int id = 1;
//        log.info("Favorite method is called {}");
//        ModelAndView mv = new ModelAndView(ViewNames.FAVORITE);
//        List<Gif> fav = gifRespository.findByFavorite(id);
//        mv.addObject("fav", fav);
//        return mv;
//    }


    // Single category page
    @RequestMapping("/categories/{categoryId}")
    public String category(@PathVariable Long categoryId, Model model) {
        // TODO: Get the category given by categoryId
        Category category = null;

        model.addAttribute("category", category);
        return "category/details";
    }

    // Form for adding a new category
    @RequestMapping("categories/add")
    public String formNewCategory(Model model) {
        // TODO: Add model attributes needed for new form

        return "category/form";
    }

    // Form for editing an existing category
    @RequestMapping("categories/{categoryId}/edit")
    public String formEditCategory(@PathVariable Long categoryId, Model model) {
        // TODO: Add model attributes needed for edit form

        return "category/form";
    }

    // Update an existing category
    @RequestMapping(value = "/categories/{categoryId}", method = RequestMethod.POST)
    public String updateCategory() {
        // TODO: Update category if valid data was received

        // TODO: Redirect browser to /categories
        return null;
    }

    // Add a category
    @RequestMapping(value = "/categories", method = RequestMethod.POST)
    public String addCategory() {
        // TODO: Add category if valid data was received

        // TODO: Redirect browser to /categories
        return null;
    }

    // Delete an existing category
    @RequestMapping(value = "/categories/{categoryId}/delete", method = RequestMethod.POST)
    public String deleteCategory(@PathVariable Long categoryId) {
        // TODO: Delete category if it contains no GIFs

        // TODO: Redirect browser to /categories
        return null;
    }




}
