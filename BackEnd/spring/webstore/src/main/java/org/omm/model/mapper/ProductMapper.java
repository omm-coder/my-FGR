package org.omm.model.mapper;

import org.omm.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();
        product.setProductId(rs.getString(1));
        product.setName(rs.getString(2));
        product.setDescription(rs.getString(3));
        product.setUnitPrice(rs.getBigDecimal(4));
        product.setManufacturer(rs.getString(5));
        product.setCategory(rs.getString(6));
        product.setCondition(rs.getString(7));
        product.setUnitsInStock(rs.getLong(8));
        product.setUnitsInOrder(rs.getLong(9));
        product.setDiscontinued(rs.getBoolean(10));
        return product;
    }
}
