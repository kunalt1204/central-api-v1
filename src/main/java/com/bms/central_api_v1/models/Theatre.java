package com.bms.central_api_v1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Theatre {
    UUID id;

    String name;

    String address;

    int pincode;

    String state;

    AppUser owner;

    String status;

}
