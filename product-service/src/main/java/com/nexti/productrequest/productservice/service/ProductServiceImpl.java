package com.nexti.productrequest.productservice.service;

import com.nexti.productrequest.productservice.dao.ProductDao;
import com.nexti.productrequest.productservice.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> listProduct() {
        return productDao.listProduct();
    }

    @Override
    public void saveProduct(Product product) {
        productDao.saveUpdateProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.saveUpdateProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        productDao.deleteProduct(id);
    }
}
