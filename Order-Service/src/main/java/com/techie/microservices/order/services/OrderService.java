package com.techie.microservices.order.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.techie.microservices.order.dto.OrderRequest;
import com.techie.microservices.order.models.Order;
import com.techie.microservices.order.repository.OrderRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        order.setSkuCode(orderRequest.skuCode());
        order.setStatus("PLACED");
        orderRepository.save(order);
    }
}
