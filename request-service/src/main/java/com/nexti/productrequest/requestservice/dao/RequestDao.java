package com.nexti.productrequest.requestservice.dao;

import com.nexti.productrequest.requestservice.model.Request;

import java.util.List;

public interface RequestDao {

    List<Request> listRequest();
    void saveUpdateRequest(Request request);
    void deleteRequest(Integer id);
}
