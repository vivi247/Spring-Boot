package com.springboot.cms.service;

import com.springboot.cms.dao.CustomerDao;
import com.springboot.cms.exception.CustomerNotFoundException;
import com.springboot.cms.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CustomerService {

    /*private List<Customer> customerList = new CopyOnWriteArrayList<Customer>();*/

    @Autowired
    private CustomerDao customerDao;

    public Customer addCustomer(Customer customer) {
        return customerDao.save(customer);
    }

    public List<Customer> getCustomerList() {

        return customerDao.findAll();
    }

    public Customer getCustomer(int customerID) throws CustomerNotFoundException{
      /*  return customerList
                .stream()
                .filter(customer -> customer.getCustomerID() == customerID)
                .findFirst()
                .get();*/
       Optional<Customer> customerOptional = customerDao.findById(customerID);
        if (!customerOptional.isPresent()) {
            throw new CustomerNotFoundException("Customer not available");
        }
      return customerOptional.get();
    }

    public Customer updateCustomer(int customerID, Customer customer) {
   /*     customerList
                .stream()
                .forEach(customer1 -> {
                    if (customer1.getCustomerID() == customerID){
                        customer1.setCustomerFirstName(customer.getCustomerFirstName());
                        customer1.setCustomerLastName(customer.getCustomerLastName());
                        customer1.setCustomerEmail(customer.getCustomerEmail());
                    }
                });

        return customerList
                .stream()
                .filter(customer2 -> customer2.getCustomerID() == customerID)
                .findFirst()
                .get();*/
            customer.setCustomerID(customerID);
            return customerDao.save(customer);
    }

    public void deleteCustomer(int customerID) throws  CustomerNotFoundException{
       /* customerList
                .stream()
                .forEach(customer -> {
                    if(customer.getCustomerID() == customerID){
                        customerList.remove(customer);
                    }
                });*/
       try {

           customerDao.deleteById(customerID);
       } catch (Exception e) {
           throw new CustomerNotFoundException(e.getMessage());
       }
    }
}
