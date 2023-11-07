package com.project.smms;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "customer")
public class Customer<OrderDetails> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String phone;
	private String email;
    private OrderDetails order_id;
    
    public Customer() {
    }

    public Customer(int id, String name, String phone, String email, OrderDetails order_id) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.order_id = order_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public OrderDetails getOrder_id() {
		return order_id;
	}

	public void setOrderDetails(OrderDetails order_id) {
		this.order_id = order_id;
	}
    @Override
    public String toString() {
        return "Customer [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", order_id=" + order_id + "]";
    }


}
