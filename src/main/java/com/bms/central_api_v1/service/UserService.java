package com.bms.central_api_v1.service;

import com.bms.central_api_v1.integration.DBAPI;
import com.bms.central_api_v1.requestbody.createuserRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

public class UserService {

    @Autowired
    DBAPI dbapi;

    public Object registerUser(createuserRB userRB){

        return dbapi.callcreateUserEndpoint(userRB);

    }



}
