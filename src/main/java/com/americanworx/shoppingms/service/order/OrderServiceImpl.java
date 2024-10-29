package com.americanworx.shoppingms.service.order;

import com.americanworx.shoppingms.domain.order.Order;
import com.americanworx.shoppingms.domain.order.OrderRequest;
import com.americanworx.shoppingms.repository.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{
    @Autowired private OrderRepository orderRepository;
    @Override
    public void saveOrder(Integer userid, OrderRequest orderRequest) throws Exception {

    }

    @Override
    public List<Order> getOrdersByUser(Integer userId) {
        return List.of();
    }

    @Override
    public Order updateOrderStatus(Integer id, String status) {
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return List.of();
    }

    @Override
    public Order getOrdersByOrderId(String orderId) {
        return null;
    }

    @Override
    public Page<Order> getAllOrdersPagination(Integer pageNo, Integer pageSize) {
        return null;
    }
}
