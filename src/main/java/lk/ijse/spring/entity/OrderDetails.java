package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderDetails {

    @EmbeddedId
    private Item_OrderDetails_PK item_orderDetails_pk;
    private int orderQty;
    private double unitPrice;

    @ManyToOne
    @JoinColumn(name = "orderId",referencedColumnName = "orderId",insertable = false,updatable = false)
    private Orders orderId;

    @ManyToOne
    @JoinColumn(name = "itemId",referencedColumnName = "itemId",insertable = false,updatable = false)
    private Items itemId;

//    public Item_OrderDetails_PK getItem_orderDetails_pk() {
//        return item_orderDetails_pk;
//    }

}
