package com.americanworx.shoppingms.service.cart;
import com.americanworx.shoppingms.domain.cart.Cart;
import java.util.List;
public interface CartService {
    public Cart saveCart(String productId, String userId);

    public List<Cart> getCartsByUser(Integer userId);

    public Integer getCountCart(Integer userId);

    public void updateQuantity(String sy, Integer cid);
}
