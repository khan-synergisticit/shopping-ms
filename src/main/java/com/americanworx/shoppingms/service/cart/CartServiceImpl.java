package com.americanworx.shoppingms.service.cart;

import com.americanworx.shoppingms.domain.cart.Cart;
import com.americanworx.shoppingms.domain.product.Product;
import com.americanworx.shoppingms.repository.cart.CartRepository;
import com.americanworx.shoppingms.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductRepository productRepository;
    @Override
    public Cart saveCart(String productId, String userId) {
        Product product = productRepository.findById(productId).orElse(null);
        Cart cart = cartRepository.findByProductIdAndUserId(productId, userId);
        if(cart == null){
            cart = new Cart();
            cart.setProduct(product);
            cart.setUserId(userId);
            cart.setQuantity(1);
            cart.setTotalPrice(1 * product.getDiscountPrice());
        }else {

            cart.setQuantity(cart.getQuantity() + 1);
            cart.setTotalPrice(cart.getQuantity() * cart.getProduct().getDiscountPrice());
        }
        return cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCartsByUser(Integer userId) {

        return List.of();
    }

    @Override
    public Integer getCountCart(Integer userId) {
        return 0;
    }

    @Override
    public void updateQuantity(String sy, Integer cid) {

    }
}
