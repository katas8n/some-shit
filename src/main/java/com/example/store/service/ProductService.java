package com.example.store.service;

import com.example.store.model.Product;
import com.example.store.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("There weren't found any product which matches to given id!"));
    }

    public Product createProduct(Product product) {
        return  productRepository.save(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductByPrice(double price) {
        return productRepository.findByPriceLessThanEqual(price);
    }
    public List<Product> getProductsByASC() {
        return productRepository.findAllByOrderByPriceAsc();
    }
    public List<Product>getProductByDESC() {
        return productRepository.findAllByOrderByPriceDesc();
    }
}
