package com.americanworx.shoppingms.service.order;
import com.americanworx.shoppingms.domain.order.Order;
import com.americanworx.shoppingms.domain.order.OrderRequest;
import java.util.List;
import org.springframework.data.domain.Page;

public interface OrderService {
    public void saveOrder(Integer userid, OrderRequest orderRequest) throws Exception;

    public List<Order> getOrdersByUser(Integer userId);

    public Order updateOrderStatus(Integer id, String status);

    public List<Order> getAllOrders();

    public Order getOrdersByOrderId(String orderId);

    public Page<Order> getAllOrdersPagination(Integer pageNo,Integer pageSize);
}
