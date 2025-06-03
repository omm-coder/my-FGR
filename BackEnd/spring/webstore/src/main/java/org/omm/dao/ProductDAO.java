package org.omm.dao;

import org.omm.model.Product;

import java.util.List;
import java.util.Map;

public interface ProductDAO {

    List<Product> getAllProducts();
    void updateStock(String name, long noOfUnits);
    List<Product> getProductsByCategory(String category);
    List<Product> getProductsByFilter(Map<String, List<String>> filterMaps);
    Product getProductById(String id);

    void addProduct(Product product);

}
