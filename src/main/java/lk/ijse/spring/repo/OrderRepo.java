package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface OrderRepo extends JpaRepository<Orders,String> {
    ArrayList<Orders> findAllByOrOrderId(String id);
}
