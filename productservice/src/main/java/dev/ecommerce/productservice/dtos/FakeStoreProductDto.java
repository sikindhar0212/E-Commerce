package dev.ecommerce.productservice.dtos;

import dev.ecommerce.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
        private long id;
        private String title;
        private String description;
        private String image;
        private Category category;
        private double price;
}
