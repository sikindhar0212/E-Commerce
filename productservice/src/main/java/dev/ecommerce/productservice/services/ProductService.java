package dev.ecommerce.productservice.services;

import dev.ecommerce.productservice.dtos.GenericProductDto;
import dev.ecommerce.productservice.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public GenericProductDto getProductById(long id) throws NotFoundException;
    public List<GenericProductDto> getAllProducts();

    public GenericProductDto createProduct(GenericProductDto genericProductDto);

    public GenericProductDto deleteProduct(Long id) throws NotFoundException;

    public GenericProductDto updateProductById(Long id,GenericProductDto genericProductDto) throws NotFoundException;
}
