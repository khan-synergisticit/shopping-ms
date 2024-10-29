package com.americanworx.shoppingms.service.category;

import com.americanworx.shoppingms.domain.category.Category;
import com.americanworx.shoppingms.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public Category create(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(String id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public List<String> findCategoryNames() {
        List<String> list = new ArrayList<>();
        List<Category> categories = categoryRepository.findAll();
        for(Category category : categories){
            list.add(category.getName());
        }
        return list;
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByName(name);
    }
}
