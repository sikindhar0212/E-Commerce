package dev.ecommerce.productservice.services;

import dev.ecommerce.productservice.dtos.GenericProductDto;
import org.springframework.stereotype.Service;


public interface ProductService {
    public GenericProductDto getProductById(long id);
}
