package com.bms.central_api_v1.Controller;

import com.bms.central_api_v1.requestbody.createuserRB;
import com.bms.central_api_v1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/central/user")
public class UserController {

    // aim : to create an endpoint which will get triggerred from fe whnever a new user is trying to register.

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody createuserRB userRB){

        userService.registerUser(userRB);

        

    }



}
