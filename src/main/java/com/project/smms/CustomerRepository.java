package com.project.smms;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.smms.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Serializable> {
}
