package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Orders {
    @Id
    private String orderId;
    private Date orderDate;

    @ManyToOne
    @JoinColumn(name = "cusId",referencedColumnName = "cusId")
    private Customer cusId;

    @OneToMany(mappedBy = "orderId" , cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails=new ArrayList<>();

}
