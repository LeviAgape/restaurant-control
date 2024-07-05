package com.example.restaurant.domain.restaurant;

import jakarta.persistence.*;
import lombok.*;

@Table(name="restaurant")
@Entity(name="restaurant")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")

public class Restaurant {

    @Id @GeneratedValue( strategy = GenerationType.UUID)
    private String id;

    private String name_restaurant;

    private String password;

    private String state;

    private String city;

    private String neighborhood;

    private Number street_number;
}
