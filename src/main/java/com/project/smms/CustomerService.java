package com.project.smms;

import java.util.List;
import org.apache.catalina.User;

public interface CustomerService<Item, Mall> {
    List<Item> searchItem(String itemName);
    Item orderItem(Item item);
    Mall searchMall(long id);
    boolean cancelOrder(long orderId);
    User login(User user);
    boolean logOut();
	String upsert(Customer customer);
	Customer getById(Integer id);
	List<Customer> getAllCustomers();
	String deleteById(Integer id);
}

