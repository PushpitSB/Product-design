package com.techie.microservices.order.dto;

import java.math.BigDecimal;

public record OrderRequest(Long Id, String orderNumber, Integer quantity, BigDecimal price, String status, String skuCode) {  
    
}
