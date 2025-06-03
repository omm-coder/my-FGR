package org.omm.service.impl;

import org.omm.dao.impl.ProductDAOIMPL;
import org.omm.model.Product;
import org.omm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Service
public class ProductServiceIMPL implements ProductService {

    @Autowired
    private ProductDAOIMPL daoImpl;
    @Override
    public List<Product> getAllProducts() {
        return daoImpl.getAllProducts();
    }


    @Override
    public void updateAllStock() {
        List<Product> allProducts = daoImpl.getAllProducts();
        for(Product product : allProducts) {
            if(product.getUnitsInStock() < 500)
                daoImpl.updateStock(product.getName(),
                                product.getUnitsInStock()+1000);
            System.out.println("updating....."+product.getName()+"WITH ID: "+ product.getProductId());
        }
        System.out.println("updated>>>>>>>>>>>>.");
    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        return daoImpl.getProductsByCategory(category);
    }

    @Override
    public List<Product> getProductsByFilter(Map<String, List<String>> filterMaps) {
        return daoImpl.getProductsByFilter(filterMaps);
    }

    @Override
    public Product getProductById(String id) {
        return daoImpl.getProductById(id);
    }

    @Override
    public void addProduct(Product product) {
        daoImpl.addProduct(product);
    }
}
