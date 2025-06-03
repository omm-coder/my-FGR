package org.omm.dao.impl;

import org.omm.dao.ProductDAO;
import org.omm.exception.ProductNotFoundException;
import org.omm.model.Product;
import org.omm.model.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductDAOIMPL implements ProductDAO {

    @Autowired
    private NamedParameterJdbcTemplate np_jdbc_template;

    //Using RowMapper With Lambda
    @Override
    public List<Product> getAllProducts() {
        return np_jdbc_template.query("Select * from products", new ProductMapper());
    }

    @Override
    public void updateStock(String name, long noOfUnits) {
        String SQL = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :unitsInStock WHERE NAME = :NAME";
        Map<String, Object> params = new HashMap<>();
        params.put("unitsInStock", noOfUnits);
        params.put("NAME", name);
        np_jdbc_template.update(SQL, params);

    }

    @Override
    public List<Product> getProductsByCategory(String category) {
        String sql = "Select * from products where category = :category";
        Map<String, Object> param = new HashMap<>();
        param.put("category", category);
        return np_jdbc_template.query(sql, param,new ProductMapper());
    }

    @Override
    public List<Product> getProductsByFilter(Map<String, List<String>> filterMaps) {
        String sql = "select * from products where category in(:categories) " +
                "and manufacturer in(:brands)";

        return np_jdbc_template.query(sql, filterMaps, new ProductMapper());
    }

    @Override
    public Product getProductById(String id) {
        String sql = "select * from productS where ID = :ID";
        Map<String, Object> param = new HashMap<>();
        param.put("ID", id);
       try {
           return np_jdbc_template.queryForObject(sql,param,new ProductMapper());
       }catch (DataAccessException e) {
           throw new ProductNotFoundException(id);
       }
    }

    @Override
    public void addProduct(Product product) {
        String sql = "INSERT INTO PRODUCTS (ID, NAME, DESCRIPTION, UNIT_PRICE,MANUFACTURER, " +
                "CATEGORY, CODITION, UNITS_IN_STOCK,UNITS_IN_ORDER, DISCONTINUED) " +
                " VALUES (:ID, :NAME, :DESCRIPTION, :UNIT_PRICE,:MANUFACTURER," +
                ":CATEGORY, :CODITION, :UNITS_IN_STOCK,:UNITS_IN_ORDER, :DISCONTINUED)";
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("ID", product.getProductId());
        params.put("NAME", product.getName());
        params.put("DESCRIPTION", product.getDescription());
        params.put("UNIT_PRICE", product.getUnitPrice());
        params.put("MANUFACTURER", product.getManufacturer());
        params.put("CATEGORY", product.getCategory());
        params.put("CODITION", product.getCondition());
        params.put("UNITS_IN_STOCK", product.getUnitsInStock());
        params.put("UNITS_IN_ORDER", product.getUnitsInOrder());
        params.put("DISCONTINUED", product.isDiscontinued());


        np_jdbc_template.update(sql,params);

    }
}
