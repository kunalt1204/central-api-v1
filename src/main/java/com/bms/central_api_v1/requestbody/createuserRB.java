package com.bms.central_api_v1.requestbody;

import com.bms.central_api_v1.enums.UserType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class createuserRB {

    String name;
    String email;
    String password;
    Long phoneNumber;
    String address;
    int pinCode;
    String state;
    UserType userType;




}
