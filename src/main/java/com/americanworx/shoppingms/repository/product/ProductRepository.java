package com.americanworx.shoppingms.repository.product;

import com.americanworx.shoppingms.domain.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
    void deleteProductById(String id);
}
