package com.nexti.productrequest.productservice.dao;

import com.nexti.productrequest.productservice.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Product> listProduct() {
        List<Product> products = null;

        try {
            products = entityManager.createQuery("from Product").getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        
        return products;
    }

    @Override
    public void saveUpdateProduct(Product product) {
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = null;
        try{
            if (!session.getTransaction().isActive()) {
                tx = session.beginTransaction();
            }
            if (product.getId() == null) {
                session.persist(product);
            } else {
                session.merge(product);
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if (tx != null) {
                tx.commit();
            }
            session.close();
        }
    }

    @Override
    public void deleteProduct(Integer id) {

        Product product = entityManager.find(Product.class, id);
        Session session = entityManager.unwrap(Session.class);

        Transaction tx = null;

        try{
            if (!session.getTransaction().isActive()) {
                tx = session.beginTransaction();
            }
            session.delete(product);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if (tx != null) {
                tx.commit();
            }
            session.close();
        }
    }
}
