package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemsDTO {
    private String itemId;
    private String itemName;
    private int itemQty;
    private double itemPrice;
}
