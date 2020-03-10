package com.nexti.productrequest.clientservice.controller;

import com.nexti.productrequest.clientservice.model.Client;
import com.nexti.productrequest.clientservice.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client-controller")
public class ClientController {

    @Autowired
    ClientService service;


    @GetMapping("/clients")
    public @ResponseBody List<Client> listClient() {
        return service.listClient();
    }

    @PostMapping("/save-client")
    public void saveClient(@RequestBody Client client) {
        service.saveClient(client);
    }

    @PutMapping("/update-client")
    public void updateClient(@RequestBody Client client) {
        service.updateClient(client);
    }

    @DeleteMapping("/delete-client/{id}")
    public void deleteClient(@PathVariable Integer id) {
        service.deleteClient(id);
    }
}
