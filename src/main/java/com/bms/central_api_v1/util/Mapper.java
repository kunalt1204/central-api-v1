package com.bms.central_api_v1.util;

import com.bms.central_api_v1.enums.TheatreStatus;
import com.bms.central_api_v1.models.AppUser;
import com.bms.central_api_v1.models.Theatre;
import com.bms.central_api_v1.requestbody.createTheatreRB;
import com.bms.central_api_v1.requestbody.createuserRB;
import org.springframework.stereotype.Service;

@Service

public class Mapper {

    public AppUser mapCreateUserRBToAppUser(createuserRB createUserRB) {
        AppUser appUser = new AppUser();
        appUser.setName(createUserRB.getName());
        appUser.setEmail(createUserRB.getEmail());
        appUser.setPassword(createUserRB.getPassword());
        appUser.setPincode(createUserRB.getPinCode());
        appUser.setAddress(createUserRB.getAddress());
        appUser.setState(createUserRB.getState());
        appUser.setPhoneNumber(createUserRB.getPhoneNumber());
        appUser.setUserType(createUserRB.getUserType().toString());
        return appUser;
    }

    public Theatre mapTheatherRBToTheatherModel(createTheatreRB createTheatreRB, AppUser owner){
        Theatre theather = new Theatre();
        theather.setAddress(theather.getAddress());
        theather.setOwner(owner);
        theather.setStatus(TheatreStatus.REQUEST_RAISED.toString());
        theather.setPincode(theather.getPincode());
        theather.setState(createTheatreRB.getState());
        theather.setName(createTheatreRB.getName());
        return theather;
    }
}