package com.project.smms;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.smms.Customer;
import com.project.smms.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService {

    // You can inject repositories or services needed for your implementation here

	@Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Override
    public List<Item> searchItem(String itemName) {
        // Implement the searchItem logic here
        return itemRepository.findByName(itemName);
    }

    @Override
    public Item orderItem(Item item) {
        // Implement the orderItem logic here
        return itemRepository.save(item);
    }

    @Override
    public Mall searchMall(long id) {
        // Implement the searchMall logic here
        return mallRepository.findById(id).orElse(null);
    }

    @Override
    public boolean cancelOrder(long orderId) {
        // Implement the cancelOrder logic here
        if (orderDetailsRepository.existsById(orderId)) {
            orderDetailsRepository.deleteById(orderId);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public User login(User user) {
        // Implement the login logic here
        // You might want to perform user authentication, e.g., checking the user's credentials
        // If authentication is successful, return the user; otherwise, return null
        return authenticateUser(user);
    }

    @Override
    public boolean logOut() {
        // Implement the logOut logic here
        // You can handle user logout functionality
        return true; // Return true if the user was successfully logged out
    }

    // Add your authentication logic here
    private User authenticateUser(User user) {
        // Example authentication logic (replace with your own authentication logic)
        // Check if the user exists and the password is correct
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return existingUser;
        }
        return null;
    }
}
