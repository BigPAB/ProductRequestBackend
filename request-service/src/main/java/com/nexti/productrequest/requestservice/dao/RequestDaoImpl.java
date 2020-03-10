package com.nexti.productrequest.requestservice.dao;

import com.nexti.productrequest.requestservice.model.Request;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class RequestDaoImpl implements RequestDao {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Request> listRequest() {
        List<Request> requests = null;

        try {
            requests  = entityManager.createQuery("from Request").getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        
        return requests;
    }

    @Override
    public void saveUpdateRequest(Request request) {
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = null;
        try{
            if (!session.getTransaction().isActive()) {
                tx = session.beginTransaction();
            }
            if (request.getId() == null) {
                session.persist(request);
            } else {
                session.merge(request);
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
    public void deleteRequest(Integer id) {

        Request request = entityManager.find(Request.class, id);
        Session session = entityManager.unwrap(Session.class);

        Transaction tx = null;

        try{
            if (!session.getTransaction().isActive()) {
                tx = session.beginTransaction();
            }
            session.delete(request);
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            if (tx != null) {
                tx.commit();
            }
            session.close();
        }
//        entityManager.getTransaction().begin();
//        entityManager.remove(request);
//        entityManager.getTransaction().commit();
    }
}
