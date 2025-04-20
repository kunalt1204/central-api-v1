package com.bms.central_api_v1.service;

import com.bms.central_api_v1.exception.UnAuthorizedException;
import com.bms.central_api_v1.integration.DBAPI;
import com.bms.central_api_v1.models.AppUser;
import com.bms.central_api_v1.requestbody.createTheatreRB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TheatreService {

    @Autowired
    UserService userService;

    public void raiseCreateTheatreRequest(createTheatreRB createTheatreRB, UUID theatreOwnerId) throws UnAuthorizedException {


        boolean isTheatherOwner = userService.isTheatreOwner(theatreOwnerId);
        if (isTheatherOwner == false){
            throw new UnAuthorizedException(
                    String.format("User with id %s does not have access to create theather.", theatreOwnerId.toString())
            );
        }
        AppUser owner = userService.getUserById(theatreOwnerId);

        // We need to call db api to create theather record inside our theather table.
        return DBAPI.callCreateTheatherEndpoint(createTheatreRB, owner);

    }


}
