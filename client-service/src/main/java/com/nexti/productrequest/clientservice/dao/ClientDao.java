package com.nexti.productrequest.clientservice.dao;

import com.nexti.productrequest.clientservice.model.Client;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ClientDao {

    List<Client> listClient();
    void saveUpdateClient(Client client);
    void deleteClient(Integer id);
}
