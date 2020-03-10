package com.nexti.productrequest.productservice.controller;

import com.nexti.productrequest.productservice.model.Product;
import com.nexti.productrequest.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product-controller")
public class ProductController {

    @Autowired
    ProductService service;


    @GetMapping("/products")
    public @ResponseBody List<Product> listProduct() {
        return service.listProduct();
    }

    @PostMapping("/save-product")
    public void saveProduct(@RequestBody Product product) {
        service.saveProduct(product);
    }

    @PutMapping("/update-product")
    public void updateProduct(@RequestBody Product product) {
        service.updateProduct(product);
    }

    @DeleteMapping("/delete-product/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        service.deleteProduct(id);
    }
}
