package com.example.ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommerce.Model.Product;
import com.example.ecommerce.Repository.ProductRepository; 

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Add product
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Get all products
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    // Update a product
    public Product updateProduct(Product productDetails, int id) {
        Product updateProduct = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with id")); 

        updateProduct.setName(productDetails.getName());
        updateProduct.setDescription(productDetails.getDescription());
        updateProduct.setPrice(productDetails.getPrice());
        updateProduct.setFeedback(productDetails.getFeedback());

        return productRepository.save(updateProduct);
    }

    // Delete a product
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }
}
