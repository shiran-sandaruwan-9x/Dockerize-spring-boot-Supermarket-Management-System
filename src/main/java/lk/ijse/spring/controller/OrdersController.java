package lk.ijse.spring.controller;

import lk.ijse.spring.dto.OrdersDTO;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.service.OrderService;
import lk.ijse.spring.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("/api/orders")
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity saveOrders(@RequestBody OrdersDTO ordersDTO){
        boolean result = orderService.saveOrders(ordersDTO);
        return new ResponseEntity(new StandardResponse("201","success",result), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity updateOrder(@RequestBody OrdersDTO ordersDTO){
        boolean result = orderService.updateOrders(ordersDTO);
        return new ResponseEntity(new StandardResponse("200","success",result),HttpStatus.OK);
    }

    @GetMapping("/getAllOrders")
    public ResponseEntity getAllOrders(){
        return new ResponseEntity(new StandardResponse("200","success",orderService.getAllOrders()),HttpStatus.OK);
    }

    @GetMapping(params = {"orderId"})
    public ResponseEntity searchOrder(@RequestParam String orderId){
       if (orderId.trim().length()<=0){
           throw new ValidateException("order id can't be empty");
       }
        System.out.println(orderId);
        ArrayList<OrdersDTO> ordersDTOS = orderService.searchOrder(orderId);
        return new ResponseEntity(new StandardResponse("200","success",ordersDTOS),HttpStatus.OK);

    }

    @DeleteMapping(params = {"orderId"})
    public ResponseEntity deleteOrder(@RequestParam String orderId){
        if (orderId.trim().length()<=0){
            throw new ValidateException("order id can't be empty");
        }
        boolean result = orderService.deleteOrder(orderId);
        return new ResponseEntity(new StandardResponse("200","success",result),HttpStatus.OK);

    }

}
