package com.americanworx.shoppingms.service.product;

import com.americanworx.shoppingms.domain.product.Product;
import java.util.List;
public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product);
    Product findProductById(String id);
    List<Product> findAll();
    void delete(String id);
}
