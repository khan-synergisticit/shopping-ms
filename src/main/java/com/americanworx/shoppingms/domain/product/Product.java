package com.americanworx.shoppingms.domain.product;

import com.americanworx.shoppingms.domain.category.Category;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document("product")
public class Product {

    @Id
    private String id;

    private String title;

    private String description;

    @DocumentReference(collection = "category")
    private Category category;

    private Double price;

    private int stock;

    private String image;

    private int discount;

    private Double discountPrice;

    private Boolean isActive;
}
