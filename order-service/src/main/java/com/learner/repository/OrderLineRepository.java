package com.learner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learner.model.OrderLineItem;
@Repository
public interface OrderLineRepository extends JpaRepository<OrderLineItem, Long>{

}
