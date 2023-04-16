package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.entity.OrderDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrdersDTO {
    private String orderId;
    private Date orderDate;
    private Customer cusId;
    private List<OrdersDetailsDTO> orderDetails=new ArrayList<>();

}
