package dev.ecommerce.productservice.controllers;

import dev.ecommerce.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;


    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public void getAllProducts() {

    }

    @GetMapping("{id}")
    public void getProductById(@PathVariable("id") long id) {

    }

    public void updateProductById() {

    }

    @PostMapping( )
    public void createProduct() {

    }

}
