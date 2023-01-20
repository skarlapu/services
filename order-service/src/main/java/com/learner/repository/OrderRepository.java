package com.learner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learner.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, String>{

}
