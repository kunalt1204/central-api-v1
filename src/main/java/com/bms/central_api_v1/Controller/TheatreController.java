package com.bms.central_api_v1.Controller;

import com.bms.central_api_v1.requestbody.createTheatreRB;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/central/theatre")
public class TheatreController {



    @PostMapping("/regiter")
    public void registerTheatre(@RequestBody createTheatreRB createTheatreRB, @RequestParam UUID ownerId){

        



    }

}
