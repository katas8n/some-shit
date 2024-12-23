package com.example.store.service;

import com.example.store.model.Cart;
import com.example.store.model.Product;
import com.example.store.model.UserDemo;
import com.example.store.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    private final CartRepository cartRepository;

    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public Cart createCart(UserDemo userDemo) {
        Cart cart = new Cart();
        cart.setUser(userDemo);
        return cartRepository.save(cart);
    }

    public Cart addProduct(Cart cart, Product product) {
        List<Product> products = cart.getProducts();
        products.add(product);
        cart.setProducts(products);
        return cartRepository.save(cart);
    }

    public Cart getCartByUser(UserDemo userDemo) {
        return cartRepository.findById(userDemo.getId()).orElseThrow(() -> new RuntimeException(("!")));
    }
}
