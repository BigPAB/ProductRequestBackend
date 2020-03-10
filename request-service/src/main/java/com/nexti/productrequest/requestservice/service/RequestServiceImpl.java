package com.nexti.productrequest.requestservice.service;

import com.nexti.productrequest.requestservice.dao.RequestDao;
import com.nexti.productrequest.requestservice.model.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestDao requestDao;

    @Transactional
    @Override
    public List<Request> listRequest() {
        return requestDao.listRequest();
    }

    @Transactional
    @Override
    public void saveRequest(Request request) {
        requestDao.saveUpdateRequest(request);
    }

    @Transactional
    @Override
    public void updateRequest(Request request) {
        requestDao.saveUpdateRequest(request);
    }

    @Transactional
    @Override
    public void deleteRequest(Integer id) {
        requestDao.deleteRequest(id);
    }
}
