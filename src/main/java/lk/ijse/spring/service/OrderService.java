package lk.ijse.spring.service;

import lk.ijse.spring.dto.ItemsDTO;
import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.entity.Orders;

import java.util.ArrayList;
import java.util.List;

public interface OrderService {
    boolean saveOrders(OrdersDTO orders);
    boolean updateOrders(OrdersDTO orders);
    boolean commonSaveUpdateMethod(OrdersDTO orders);
    ArrayList<OrdersDTO> getAllOrders();
    boolean deleteOrder(String oid);
    ArrayList<OrdersDTO> searchOrder(String oid);
}
