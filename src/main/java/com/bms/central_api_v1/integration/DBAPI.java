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

public class DBAPI {


    @Value("${db.api.base}")
    String baseUrl;

    @Autowired
    Mapper mapper;

    public AppUser callcreateUserEndpoint(@RequestBody createuserRB createuserRB){
        // Create url.
        String url = baseUrl + "/user/create";
        URI finalUrl = URI.create(url);
        AppUser appUser;
        appUser = mapper.mapCreateUserRBToAppUser(createuserRB);
        // start creating request
        RequestEntity<Object> request = RequestEntity.post(finalUrl).body(appUser);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<AppUser> responseEntity = restTemplate.exchange(finalUrl, HttpMethod.POST,request, AppUser.class);

        return responseEntity.getBody();









    }


}
