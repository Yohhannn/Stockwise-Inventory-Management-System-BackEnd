package com.stockwiseinventory.stockwiseInventory.service;

import com.stockwiseinventory.stockwiseInventory.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product saveProduct(Product product);

    List<Product> getAllProducts();

    Optional<Product> getProductById(int id);

    Product updateProduct(int id, Product product);

    void deleteProduct(int id);

    List<Product> searchProducts(String name);

    List<Product> getProductsByCategory(String category);

}
