package com.example.restaurant.domain.product;


import jakarta.persistence.*;
import lombok.*;

@Table(name="product")
@Entity(name="product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Product {
    @Id @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    private String name;

    private Float price;

    private String description;

    private String image;

    public Product(RequestProduct requestProduct){
        this.name = requestProduct.name();
        this.price = requestProduct.price();
        this.description = requestProduct.description();
        this.image = requestProduct.image();
    }
}
