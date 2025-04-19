package com.bms.central_api_v1.integration;

import com.bms.central_api_v1.models.AppUser;
import com.bms.central_api_v1.requestbody.createuserRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.bms.central_api_v1.util.Mapper;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.HashMap;

public class DBAPI extends RestAPI{


    @Value("${db.api.base}")
    String baseUrl;

    @Autowired
    Mapper mapper;

    public Object callcreateUserEndpoint(@RequestBody createuserRB createuserRB){
        // Create url.

        AppUser appUser = mapper.mapCreateUserRBToAppUser(createuserRB);

        String endPoint = "/user/create";

        Object resp = this.makePostCall(baseUrl,endPoint,appUser,new HashMap<>());

        return resp;

    }


}
