package com.techie.microservices.order.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.techie.microservices.order.dto.OrderRequest;
import com.techie.microservices.order.services.OrderService;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest order) {
        orderService.placeOrder(order);
        return "Order Placed succesfuly";
    }
    

}