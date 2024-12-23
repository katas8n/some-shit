package com.example.store.controller;

import com.example.store.model.Cart;
import com.example.store.model.Product;
import com.example.store.model.UserDemo;
import com.example.store.service.CartService;
import com.example.store.service.ProductService;
import com.example.store.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/carts")
public class CartController {
    private CartService cartService;
    private UserService userService;
    private ProductService productService;

    public CartController(CartService cartService, UserService userService, ProductService productService) {
        this.cartService = cartService;
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("/{userId}")
    public Cart createCart(@PathVariable Long userId) {
         UserDemo userDemo = userService.getUserById(userId);

         return  cartService.createCart(userDemo);
    }

    @PostMapping("/{cartId}/add/{productId}")
    public Cart addProductToCart(@PathVariable Long cartId,@PathVariable Long productID) {
        Cart cart = cartService.getCartByUser(userService.getUserById(cartId));
        Product product = productService.getProducts()
                .stream().filter(p -> p.getId().equals(productID))
                .findFirst().orElseThrow(() -> new RuntimeException("Product not found"));

        return cartService.addProduct(cart, product);
    }

    @GetMapping("/{userId}")
    public Cart getCartByUser(@PathVariable Long userId) {
        UserDemo userDemo = userService.getUserById(userId);

        return cartService.getCartByUser(userDemo);
    }
}
