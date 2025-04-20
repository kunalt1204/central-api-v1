package com.bms.central_api_v1.service;

import com.bms.central_api_v1.enums.UserType;
import com.bms.central_api_v1.exception.UserNotFoundException;
import com.bms.central_api_v1.integration.DBAPI;
import com.bms.central_api_v1.models.AppUser;
import com.bms.central_api_v1.requestbody.createuserRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

public class UserService {

    @Autowired
    DBAPI dbapi;

    public Object registerUser(createuserRB userRB){

        return dbapi.callcreateUserEndpoint(userRB);

    }

    public AppUser getUserById(UUID userId){

        return dbapi.callUserByIDEndPoint(userId);

    }

    public boolean isTheatreOwner(UUID theatreOwnerId){

        AppUser theatreOwner = this.getUserById(theatreOwnerId);

        if(theatreOwner == null){
            throw new UserNotFoundException(String.format("Invalid theatreOwner %s",theatreOwnerId.toString()));
        }

        return theatreOwner.getUserType() == UserType.THEATRE_OWNER.toString() ? true : false;

    }



}
