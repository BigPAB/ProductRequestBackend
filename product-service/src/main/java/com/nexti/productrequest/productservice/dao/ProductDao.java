package com.nexti.productrequest.productservice.dao;

import com.nexti.productrequest.productservice.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> listProduct();
    void saveUpdateProduct(Product product);
    void deleteProduct(Integer id);
}
