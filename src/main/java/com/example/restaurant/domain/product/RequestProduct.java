package com.example.restaurant.domain.product;

public record RequestProduct(
        String id,

        String name,

        Float price,

        String description,

        String image
) {
}
