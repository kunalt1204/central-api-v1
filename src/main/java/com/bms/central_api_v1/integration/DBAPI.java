package com.bms.central_api_v1.integration;

import com.bms.central_api_v1.models.AppUser;
import com.bms.central_api_v1.models.Theatre;
import com.bms.central_api_v1.requestbody.createTheatreRB;
import com.bms.central_api_v1.requestbody.createuserRB;
import org.modelmapper.ModelMapper;
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
import java.util.UUID;

import static jdk.nio.zipfs.ZipFileAttributeView.AttrID.owner;

public class DBAPI extends RestAPI{


    @Value("${db.api.base}")
    String baseUrl;

    @Autowired
    Mapper mapper;

    @Autowired
    ModelMapper modelMapper;

    public AppUser callcreateUserEndpoint(@RequestBody createuserRB createuserRB){
        // Create url.

        AppUser appUser = mapper.mapCreateUserRBToAppUser(createuserRB);

        String endPoint = "/user/create";

        Object resp = this.makePostCall(baseUrl,endPoint,appUser,new HashMap<>());

        AppUser userResp = modelMapper.map(resp, AppUser.class);


        return userResp;

    }

    public AppUser callUserByIDEndPoint(UUID userId){
        String endPoint = "/user/" + userId.toString();
       Object response =  this.makeGetCall(baseUrl,endPoint,new HashMap<>());
       if(response == null){
           return null;
       }
       return modelMapper.map(response, AppUser.class);
    }

    public static Theatre callCreateTheatreEndpoint(createTheatreRB createTheatreRB, AppUser owner){
        Theatre theather = mapper.mapTheatherRBToTheatherModel(createTheatreRB, owner);
        String endPoint = "/theather/create";
        Object resp = this.makePostCall(baseUrl, endPoint, theather, new HashMap<>());
        return modelMapper.map(resp, Theatre.class);

    }


}
