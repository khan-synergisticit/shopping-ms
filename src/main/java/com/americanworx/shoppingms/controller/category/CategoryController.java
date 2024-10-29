package com.americanworx.shoppingms.controller.category;

import com.americanworx.shoppingms.config.Constants;
import com.americanworx.shoppingms.domain.category.Category;
import com.americanworx.shoppingms.domain.product.Product;
import com.americanworx.shoppingms.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = Constants.FRONTEND_URL)
@RestController
@RequestMapping("/api/category")
public class CategoryController {


    @Autowired
    CategoryService categoryService;

    @RequestMapping(value = "/private", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Category category){
        Category category1= categoryService.create(category);
        return new ResponseEntity<>(category1, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/public/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable String id){
        Category category1 = categoryService.findById(id);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }

    @RequestMapping(value = "/private", method = RequestMethod.PUT)
    public ResponseEntity<?> updateById(@RequestBody Category category){
        Category category1 = categoryService.update(category);
        return new ResponseEntity<>(category1, HttpStatus.OK);
    }

    @Cacheable("categoryNames")
    @RequestMapping(value = "/public/names", method = RequestMethod.GET)
    public ResponseEntity<?> findCategoryNames(){
        List<String> names = categoryService.findCategoryNames();
        return new ResponseEntity<>(names, HttpStatus.OK);
    }
}
