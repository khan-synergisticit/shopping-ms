package com.americanworx.shoppingms.domain.order;

import com.americanworx.shoppingms.domain.product.Product;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document("order")
public class Order {
    @Id
    private String id;

    private String orderId;

    private LocalDate orderDate;

    @DocumentReference(collection = "product")
    private Product product;

    private Double price;

    private Integer quantity;


    private String userId;

    private String status;

    private String paymentType;

    @DocumentReference(collection = "address")
    private Address orderAddress;
}
