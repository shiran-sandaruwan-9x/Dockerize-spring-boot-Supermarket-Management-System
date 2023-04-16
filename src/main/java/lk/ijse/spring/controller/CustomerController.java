package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.service.CustomerService;
import lk.ijse.spring.utils.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/customer")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping
    public ResponseEntity saveCustomer(@RequestBody CustomerDTO dto){
        if (dto.getCusId().trim().length()<=0 && dto.getCusName().trim().length()<=0){
            throw new ValidateException("customer id or customer not be empty!");
        }
        service.addCustomer(dto);
        return new ResponseEntity(new StandardResponse("200","success","customer saved"), HttpStatus.CREATED);
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity getAllCustomers(){
        return new ResponseEntity(new StandardResponse("200","success",service.getAllCustomer()),HttpStatus.OK);
    }

    @GetMapping(params = {"cusId","cusName"})
    public ResponseEntity searchCustomer(@RequestParam String cusId,@RequestParam String cusName){
        return new ResponseEntity(new StandardResponse("200","success",service.searchCustomer(cusId,cusName)),HttpStatus.OK);
    }

    @DeleteMapping("/{cusId}")
    public ResponseEntity deleteCustomer(@PathVariable String cusId){
        return new ResponseEntity(new StandardResponse("200","success",service.deleteCustomer(cusId)),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity updateCustomer(@RequestBody CustomerDTO dto){
        return new ResponseEntity(new StandardResponse("200","success",service.updateCustomer(dto)),HttpStatus.OK);
    }

}
