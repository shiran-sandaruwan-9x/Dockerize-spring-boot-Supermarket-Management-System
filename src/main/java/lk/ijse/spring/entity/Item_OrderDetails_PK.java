package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class Item_OrderDetails_PK implements Serializable {
    //private static final long serialVersionUID = 4582703867128131348L;
    private String itemId;
    private String orderId;
}
