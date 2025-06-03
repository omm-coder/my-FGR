package org.omm.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.omm.exception.NoProductsFound;
import org.omm.exception.ProductNotFoundException;
import org.omm.model.Product;
import org.omm.service.impl.ProductServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    private ProductServiceIMPL serviceIMPL;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/accessDenied")
    public String accessDeniedPage() {
        return "accessDenied";
    }
    @GetMapping(value = "product")
    public String getProduct(@RequestParam String id, Model model) {
        model.addAttribute("product",serviceIMPL.getProductById(id));
      return "store/product";
    }
    @GetMapping("/products")
    public String getProducts(Model model) {
        model.addAttribute("products", serviceIMPL.getAllProducts());
        return "store/products";
    }

    @GetMapping("/update/stock")
    public String updateStock() {
        serviceIMPL.updateAllStock();
        return "redirect:/products";
    }

    @GetMapping("/products/{category}")
    public String getProductsByCategory(@PathVariable String category, Model model) {
        List<Product> products = serviceIMPL.getProductsByCategory(category);
        if (products == null || products.isEmpty())
            throw new NoProductsFound();
        model.addAttribute("products",
                serviceIMPL.getProductsByCategory(category));
        return "store/products";
    }

//    /products/filter/params;brands=Goo
//            gle,Dell;categories=Tablet,Laptop to access the url
    @GetMapping("/products/filter/{params}")
    public String getProductsByFilter(@MatrixVariable(pathVar = "params")
                                      Map<String, List<String>> filterParams, Model model) {
        model.addAttribute("products",
                serviceIMPL.getProductsByFilter(filterParams));
        return "store/products";
    }


    @GetMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product) {
        return "store/addProduct";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@Valid @ModelAttribute Product product,
                              BindingResult bindingResult, HttpServletRequest request) {
       if (bindingResult.hasErrors()) {
           System.out.println(bindingResult.getFieldError());
           return "store/addProduct";
       }

       MultipartFile productImage = product.getProductImage();
       String rootDirectory = request.getSession().getServletContext()
                .getRealPath("/");
       if ((productImage!= null && !productImage.isEmpty())) {
            try {
                productImage.transferTo(
                        new File(rootDirectory+"WEB-INF\\static\\images\\"+product.getProductId()+".png"));
            } catch (IOException e) {
                throw new RuntimeException("Product Image saving failed: " + e);
            }
       }
       serviceIMPL.addProduct(product);
        return "redirect:/products";
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public String handleError(HttpServletRequest req,
                              ProductNotFoundException exception,
                              Model model) {
        model.addAttribute("invalidProductId",exception.getProductId());
        model.addAttribute("exception", exception);
        model.addAttribute("url",
                req.getRequestURL()+"?"+req.getQueryString());
        return "store/error";
    }

   @InitBinder
    public void InitBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Product.class,new StringTrimmerEditor(true));

   }
}
