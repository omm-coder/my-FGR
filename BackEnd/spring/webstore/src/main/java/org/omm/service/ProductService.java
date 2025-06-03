package org.omm.service;

import org.omm.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> getAllProducts();
    void updateAllStock();
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByFilter(Map<String, List<String>> filterMaps);
    Product getProductById(String id);

    void addProduct(Product product);
}
