package com.nexti.productrequest.productservice.service;

import com.nexti.productrequest.productservice.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> listProduct();
    void saveProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Integer id);
}
