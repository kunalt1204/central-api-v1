package com.bms.central_api_v1.requestbody;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class createTheatreRB {

    String name;

    String address;

    int pincode;

    String state;

}
