package com.springboot.cms.api;

import com.springboot.cms.exception.CustomerNotFoundException;
import com.springboot.cms.model.Customer;
import com.springboot.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
@RestController
@RequestMapping("/customers")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer) {
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getCustomerList();

    }

    @GetMapping("/{customerID}")
    public Customer getCustomer(@PathVariable("customerID") int customerID) throws CustomerNotFoundException {
        return customerService.getCustomer(customerID);
    }

    @PutMapping("/{customerID}")
    public Customer updateCustomer (@PathVariable("customerID") int customerID, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerID, customer);
    }

    @PatchMapping("/{customerID}")
    public Customer updatePatchCustomer (@PathVariable("customerID") int customerID, @RequestBody Customer customer) {
        return customerService.updateCustomer(customerID, customer);
    }

    @DeleteMapping("/{customerID}")
    public void deleteCustomer(@PathVariable("customerID") int customerID) throws CustomerNotFoundException{
        customerService.deleteCustomer(customerID);
    }
}
