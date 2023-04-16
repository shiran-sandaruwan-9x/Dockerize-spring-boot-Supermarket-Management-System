package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.ItemsDTO;
import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.dto.OrdersDetailsDTO;
import lk.ijse.spring.entity.Items;
import lk.ijse.spring.entity.OrderDetails;
import lk.ijse.spring.entity.Orders;
import lk.ijse.spring.exception.NullPointException;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.ItemRepo;
import lk.ijse.spring.repo.OrderRepo;
import lk.ijse.spring.service.ItemService;
import lk.ijse.spring.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean saveOrders(OrdersDTO orders) {

        if (orders!=null){
            if (orderRepo.existsById(orders.getOrderId())){
                throw new ValidateException("order already exist!");
            }else{
            return commonSaveUpdateMethod(orders);
            }
        }
        throw new NullPointException("input order details");
    }

    @Override
    public boolean updateOrders(OrdersDTO orders) {
        if (orders!=null){
            if (orderRepo.existsById(orders.getOrderId())){
                return commonSaveUpdateMethod(orders);
            }else{
                throw new ValidateException("order already exist!");
            }
        }
        throw new NullPointException("input order details");
    }

    @Override
    public boolean commonSaveUpdateMethod(OrdersDTO orders) {
        ArrayList<OrdersDetailsDTO> orderDetails = (ArrayList<OrdersDetailsDTO>) orders.getOrderDetails();
        for (int i=0; i<orderDetails.size(); i++) {
            Optional<Items> items = itemRepo.findById(orderDetails.get(i).getItem_orderDetails_pk().getItemId().trim());
            if (items.isPresent()){
                Items items1 = items.get();
                int newQty=items1.getItemQty()-orderDetails.get(i).getOrderQty();
                if (newQty>=0){
                    items1.setItemQty(newQty);
                    itemService.updateItems(mapper.map(items1,ItemsDTO.class));
                    orderRepo.save(mapper.map(orders,Orders.class));
                }else{
                    throw new ValidateException("item qty can't be minus numbers");
                }
            }
        }
        return true;
    }

    @Override
    public ArrayList<OrdersDTO> getAllOrders() {
        List<Orders> all = orderRepo.findAll();
        if (all!=null && !all.isEmpty()){
            return mapper.map(all,new TypeToken<ArrayList<OrdersDTO>>(){}.getType());
        }
        throw new NullPointException("don't have orders");
    }

    @Override
    public boolean deleteOrder(String oid) {
        if (orderRepo.existsById(oid)){
            orderRepo.deleteById(oid);
            return true;
        }
        throw new ValidateException("this order not be exist");
    }

    @Override
    public ArrayList<OrdersDTO> searchOrder(String oid) {
            if (orderRepo.existsById(oid)){
               return mapper.map(orderRepo.findAllByOrOrderId(oid),new TypeToken<ArrayList<OrdersDTO>>(){}.getType());
        }
        throw new ValidateException("order not be exist");
    }


}
