package com.example.store.controller;

import com.example.store.model.Product;
import com.example.store.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/products")
public class ProductController {
    public ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/id")
    public Product getProductById (@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

//    @GetMapping("/filter")
//    public List<Product> filterByPrice(@RequestParam double price) {
//       return productService.getProductByPrice(price);
//    }

    @GetMapping("/sort/desc")
    public List<Product> sortByPriceDesc() {
        return productService.getProductByDESC();
    }
    @GetMapping("/sort/asc")
    public List<Product> sortByPriceAsc() {
        return productService.getProductsByASC();
    }

}
