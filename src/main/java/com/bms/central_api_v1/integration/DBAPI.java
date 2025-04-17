package com.bms.central_api_v1.integration;

import com.bms.central_api_v1.models.AppUser;
import com.bms.central_api_v1.requestbody.createuserRB;
import org.apache.catalina.mapper.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

public class DBAPI {


    @Value("${db.api.base}")
    String baseUrl;

    @Autowired
    Mapper mapper;

    public void createUser( @RequestBody createuserRB createuserRB){
        // Create url.
        String url = baseUrl + "/user/create";
        URI finalUrl = URI.create(url);
        // start creating request
        RequestEntity<Object> request = RequestEntity.post(finalUrl).body(appUser);





    }


}
