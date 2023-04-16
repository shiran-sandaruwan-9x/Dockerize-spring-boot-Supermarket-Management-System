package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class CustomerServiceTest {

    @Autowired
    CustomerService service;

    @Test
    void searchCustomer() {
        List<CustomerDTO> customerDTOS= service.searchCustomer("C002", "");
        System.out.println(customerDTOS.toString());
    }
}
