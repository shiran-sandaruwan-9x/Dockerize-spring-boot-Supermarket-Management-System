package lk.ijse.spring.dto;

import lk.ijse.spring.entity.Item_OrderDetails_PK;
import lk.ijse.spring.entity.Items;
import lk.ijse.spring.entity.Orders;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrdersDetailsDTO {
    private Item_OrderDetails_PK item_orderDetails_pk;
    private int orderQty;
    private double unitPrice;
}
