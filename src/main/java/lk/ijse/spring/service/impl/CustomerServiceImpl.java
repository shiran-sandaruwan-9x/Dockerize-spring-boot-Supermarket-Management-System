package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.CustomerDTO;
import lk.ijse.spring.entity.Customer;
import lk.ijse.spring.exception.NotFoundException;
import lk.ijse.spring.exception.NullPointException;
import lk.ijse.spring.exception.ValidateException;
import lk.ijse.spring.repo.CustomerRepo;
import lk.ijse.spring.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public boolean addCustomer(CustomerDTO customerDTO) {
       if (customerDTO!=null){
           if (customerRepo.existsById(customerDTO.getCusId())){
               throw new ValidateException("customer already exist !");
           }
           customerRepo.save(mapper.map(customerDTO,Customer.class));
           return true;
       }
       throw new NullPointException("add customer save details");
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        List<Customer> all = customerRepo.findAll();
        if (all!=null){
           return mapper.map(all, new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
        }
        throw new NotFoundException("customers not exist !");
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) {
       if (dto!=null){
           if (customerRepo.existsById(dto.getCusId())){
               customerRepo.save(mapper.map(dto,Customer.class));
               return true;
           }
           throw new NotFoundException("this customer not exist !");
       }
       throw new NullPointException("add customer update details");
    }

    @Override
    public List<CustomerDTO> searchCustomer(String cusId, String cusName) {
        if (cusId!="" || cusName!=""){
            return mapper.map(customerRepo.findByCusIdOrCusName(cusId,cusName),new TypeToken<ArrayList<CustomerDTO>>(){}.getType());
        }
        throw new NotFoundException("this customer not exist !");
    }

    @Override
    public boolean deleteCustomer(String cusId) {
        if (customerRepo.existsById(cusId)){
            customerRepo.deleteById(cusId);
            return true;
        }
        throw new NotFoundException("this customer not exits!");
    }
}
