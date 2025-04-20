package com.bms.central_api_v1.Controller;

import com.bms.central_api_v1.exception.UnAuthorizedException;
import com.bms.central_api_v1.exception.UserNotFoundException;
import com.bms.central_api_v1.models.Theatre;
import com.bms.central_api_v1.requestbody.createTheatreRB;
import com.bms.central_api_v1.responseBody.GeneralMessageResponse;
import com.bms.central_api_v1.service.TheatreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/central/theatre")
public class TheatreController {


    @PostMapping("/register")
    public ResponseEntity registerTheatre(@RequestBody createTheatreRB createTheatreRB, @RequestParam UUID ownerId) {
        try {
            Theatre theather = TheatreService.raiseCreateTheatreRequest(createTheatreRB, ownerId);
            return new ResponseEntity(theather, HttpStatus.CREATED);
        } catch (UnAuthorizedException e) {
            GeneralMessageResponse message = new GeneralMessageResponse();
            message.setMessage(e.getMessage());
            return new ResponseEntity(message, HttpStatus.UNAUTHORIZED);
        } catch (UserNotFoundException e) {
            GeneralMessageResponse message = new GeneralMessageResponse();
            message.setMessage(e.getMessage());
            return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            GeneralMessageResponse message = new GeneralMessageResponse();
            message.setMessage(e.getMessage());
            return new ResponseEntity(message, HttpStatus.INTERNAL_SERVER_ERROR);


        }

    }

}
