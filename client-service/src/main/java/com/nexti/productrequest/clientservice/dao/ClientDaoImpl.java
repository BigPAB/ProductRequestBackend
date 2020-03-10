package com.nexti.productrequest.clientservice.dao;

import com.nexti.productrequest.clientservice.model.Client;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ClientDaoImpl implements ClientDao {

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Client> listClient() {
        List<Client> clients = null;

        try {
            clients = entityManager.createQuery("from Client").getResultList();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            entityManager.close();
        }
        
        return clients;
    }

    @Override
    public void saveUpdateClient(Client client) {
        Session session = entityManager.unwrap(Session.class);
        Transaction tx = null;
        try{
            if (!session.getTransaction().isActive()) {
                tx = session.beginTransaction();
            }
            if (client.getId() == null) {
                session.persist(client);
            } else {
                session.merge(client);
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
    public void deleteClient(Integer id) {

        Client client = entityManager.find(Client.class, id);
        Session session = entityManager.unwrap(Session.class);

        Transaction tx = null;

        try{
            if (!session.getTransaction().isActive()) {
                tx = session.beginTransaction();
            }
            session.delete(client);
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
