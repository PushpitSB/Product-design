package com.techie.microservices.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techie.microservices.order.models.Order;

public interface  OrderRepository extends JpaRepository<Order, Long>{
    
}