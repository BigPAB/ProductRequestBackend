package com.nexti.productrequest.clientservice.service;

import com.nexti.productrequest.clientservice.model.Client;

import java.util.List;

public interface ClientService {

    public List<Client> listClient();
    public void saveClient(Client client);
    public void updateClient(Client client);
    public void deleteClient(Integer id);
}
