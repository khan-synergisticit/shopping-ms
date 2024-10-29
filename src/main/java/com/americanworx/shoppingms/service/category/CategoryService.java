package com.americanworx.shoppingms.service.category;

import com.americanworx.shoppingms.domain.category.Category;
import java.util.List;
public interface CategoryService {
    Category create(Category category);
    Category update(Category category);
    Category findById(String id);
    List<Category> findAll();
    List<String> findCategoryNames();
    Category findByName(String name);

}
