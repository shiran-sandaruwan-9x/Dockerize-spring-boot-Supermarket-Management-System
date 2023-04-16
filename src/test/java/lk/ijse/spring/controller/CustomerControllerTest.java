package lk.ijse.spring.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class CustomerControllerTest {

    @Autowired
    CustomerController controller;

    @Test
    void searchCustomer() {
        ResponseEntity response = controller.searchCustomer("C001", "kamal");
        System.out.println(response.toString());
    }
}
