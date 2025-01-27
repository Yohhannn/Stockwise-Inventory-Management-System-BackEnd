package com.stockwiseinventory.stockwiseInventory.service;

import com.stockwiseinventory.stockwiseInventory.model.Product;
import com.stockwiseinventory.stockwiseInventory.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Save or update a product
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    // Get all products
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // Get a product by ID
    @Override
    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    // Update an existing product
    @Override
    public Product updateProduct(int id, Product product) {
        if (productRepository.existsById(id)) {
            product.setId(id);
            return productRepository.save(product);
        }
        return null;
    }

    // Delete a product by ID
    @Override
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    // Search products by name
    @Override
    public List<Product> searchProducts(String name) {
        return productRepository.findByNameContaining(name);
    }


    // Filter by category
    @Override
    public List<Product> getProductsByCategory(String category) {
        return productRepository.findByCategoryContainsIgnoreCase(category);
    }

}
