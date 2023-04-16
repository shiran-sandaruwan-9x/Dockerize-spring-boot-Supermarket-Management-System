package lk.ijse.spring.service;

import lk.ijse.spring.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    boolean addCustomer(CustomerDTO customerDTO);
    List<CustomerDTO> getAllCustomer();
    boolean updateCustomer(CustomerDTO dto);
    List<CustomerDTO> searchCustomer(String cusId,String cusName);
    boolean deleteCustomer(String cusId);
}
