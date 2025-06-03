package org.omm.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.omm.validation.Category;
import org.omm.validation.ProductId;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class Product implements Serializable {

    @Pattern(regexp = "P[1-9]+", message="{Pattern.Product.productId.validation}")
    @ProductId
    private String productId;
    @NotNull(message = "{Null.Product.name.validation}")
    @NotEmpty(message = "{Empty.Product.name.validation}")
    private String name;
    @NotNull(message = "{Null.Product.unitPrice.validation}")
    private BigDecimal unitPrice;
    @NotEmpty(message = "{Empty.Product.description.validation}")
    private String description;
    @NotEmpty(message = "{Empty.Product.manufacturer.validation}")
    private String manufacturer;
    @NotEmpty(message = "{Empty.Product.category.validation}")
    @Size(min = 3,message = "{Empty.Product.category.validation}")
    @Category
    private String category;
    private Long unitsInStock;
    private Long unitsInOrder;
    private boolean discontinued;
    private String condition;
    private MultipartFile productImage;


    public Product(String productId, String name, BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }




}
