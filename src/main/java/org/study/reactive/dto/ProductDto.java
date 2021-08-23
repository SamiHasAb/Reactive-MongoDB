package org.study.reactive.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {

    private String productId;
    private String productName;
    private int qty;
    private double price;
}
