package com.techie.microservices.product.dto;

import java.math.BigDecimal;

public record  ProductResponse(String Id, String name, String description, BigDecimal price) {
    
}
