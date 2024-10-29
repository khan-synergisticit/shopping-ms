package com.americanworx.shoppingms.repository.cart;
import com.americanworx.shoppingms.domain.cart.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
public interface CartRepository extends MongoRepository<Cart, String> {
    public Cart findByProductIdAndUserId(String productId, String userId);

    public Integer countByUserId(String userId);

    public List<Cart> findByUserId(String userId);
}
