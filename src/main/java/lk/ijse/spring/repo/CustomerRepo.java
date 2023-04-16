package lk.ijse.spring.repo;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepo extends JpaRepository<Customer,String> {
    List<Customer> findByCusIdOrCusName(String cusId, String cusName);

}
