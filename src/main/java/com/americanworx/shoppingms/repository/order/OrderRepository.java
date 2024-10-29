package com.americanworx.shoppingms.repository.order;

import com.americanworx.shoppingms.domain.order.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findByUserId(String userId);

    Order findByOrderId(String orderId);
}