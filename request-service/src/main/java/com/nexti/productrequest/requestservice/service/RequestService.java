package com.nexti.productrequest.requestservice.service;

import com.nexti.productrequest.requestservice.model.Request;

import java.util.List;

public interface RequestService {

    List<Request> listRequest();
    void saveRequest(Request request);
    void updateRequest(Request request);
    void deleteRequest(Integer id);
}
