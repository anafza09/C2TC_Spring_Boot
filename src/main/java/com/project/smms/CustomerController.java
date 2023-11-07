package com.project.smms;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.project.exceptions.CustomerNotFound;
import com.project.smms.Customer;
import com.project.smms.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<String> createCustomer(@RequestBody Customer customer) {
        String status = customerService.upsert(customer);
        return new ResponseEntity<>(status, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        try {
            Customer customer = customerService.getById(id);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } catch (CustomerNotFound ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> allCustomers = customerService.getAllCustomers();
        return new ResponseEntity<>(allCustomers, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateCustomer(@RequestBody Customer customer) {
        String status = customerService.upsert(customer);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable Integer id) {
        try {
            String status = customerService.deleteById(id);
            return new ResponseEntity<>(status, HttpStatus.OK);
        } catch (CustomerNotFound ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/searchItem")
    public ResponseEntity<List<Item>> searchItem(@RequestParam String itemName) {
        List<Item> items = customerService.searchItem(itemName);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping("/orderItem")
    public ResponseEntity<Item> orderItem(@RequestBody Item item) {
        Item orderedItem = customerService.orderItem(item);
        return new ResponseEntity<>(orderedItem, HttpStatus.CREATED);
    }

    @GetMapping("/searchMall/{id}")
    public ResponseEntity<Mall> searchMall(@PathVariable long id) {
        Mall mall = customerService.searchMall(id);
        return new ResponseEntity<>(mall, HttpStatus.OK);
    }

    @DeleteMapping("/cancelOrder/{orderId}")
    public ResponseEntity<Boolean> cancelOrder(@PathVariable long orderId) {
        boolean result = customerService.cancelOrder(orderId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User loggedInUser = customerService.login(user);
        return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
    }

    @GetMapping("/logOut")
    public ResponseEntity<Boolean> logOut() {
        boolean loggedOut = customerService.logOut();
        return new ResponseEntity<>(loggedOut, HttpStatus.OK);
    }
}
