package com.americanworx.shoppingms.controller.product;

import com.americanworx.shoppingms.config.Constants;
import com.americanworx.shoppingms.domain.category.Category;
import com.americanworx.shoppingms.domain.product.Product;
import com.americanworx.shoppingms.service.category.CategoryService;
import com.americanworx.shoppingms.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = Constants.FRONTEND_URL)
public class ProductController {
    @Autowired private ProductService productService;
    @Autowired private CategoryService categoryService;

    @RequestMapping(value = "/private", method = RequestMethod.POST)
    public ResponseEntity<?> save(@RequestBody Product product){
        System.out.println("product: " + product.toString());
        Category category = categoryService.findByName(product.getCategory().getName());
        product.setCategory(category);
        Product savedProduct = productService.createProduct(product);
        System.out.println("savedProduct: " + savedProduct.toString());
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/public/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> findById(@PathVariable String id){
        Product product = productService.findProductById(id);
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(product, HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/private", method = RequestMethod.PUT)
    public ResponseEntity<?> updateById(@RequestBody Product product){
        Product updatedProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    @RequestMapping(value = "/private/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@PathVariable String id){
        productService.delete(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/public/all", method = RequestMethod.GET)
    public ResponseEntity<?> fetchAll(){
        List<Product> products = productService.findAll();
        System.out.println("Prods: " + products.toString());
        return  new ResponseEntity<>(products, HttpStatus.OK);
    }
}
