package org.study.reactive.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collation = "products")
public class Product {
    @Id
    private UUID productId;
    private String productName;
    private int qty;
    private double price;
}
