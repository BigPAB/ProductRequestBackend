package com.nexti.productrequest.clientservice.service;

import com.nexti.productrequest.clientservice.dao.ClientDao;
import com.nexti.productrequest.clientservice.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientDao clientDao;

    @Override
    public List<Client> listClient() {
        return clientDao.listClient();
    }

    @Transactional
    @Override
    public void saveClient(Client client) {
        clientDao.saveUpdateClient(client);
    }

    @Override
    public void updateClient(Client client) {
        clientDao.saveUpdateClient(client);
    }

    @Override
    public void deleteClient(Integer id) {
        clientDao.deleteClient(id);
    }
}
