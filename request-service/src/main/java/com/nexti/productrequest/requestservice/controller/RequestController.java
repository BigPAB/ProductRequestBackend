package com.nexti.productrequest.requestservice.controller;

import com.nexti.productrequest.requestservice.model.Request;
import com.nexti.productrequest.requestservice.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("request-controller")
public class RequestController {

    @Autowired
    RequestService service;

    @GetMapping("/requests")
    public @ResponseBody List<Request> listRequest() {
        return service.listRequest();
    }

    @PostMapping("/save-request")
    public void saveRequest(@RequestBody Request request) {
        service.saveRequest(request);
    }

    @PutMapping("/update-request")
    public void updateRequest(@RequestBody Request request) {
        service.updateRequest(request);
    }

    @DeleteMapping("/delete-request/{id}")
    public void deleteRequest(@PathVariable Integer id) {
        service.deleteRequest(id);
    }
}
