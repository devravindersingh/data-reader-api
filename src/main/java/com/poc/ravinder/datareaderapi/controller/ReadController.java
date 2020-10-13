package com.poc.ravinder.datareaderapi.controller;

import com.poc.ravinder.datareaderapi.model.State;
import com.poc.ravinder.datareaderapi.response.ReadResponse;
import com.poc.ravinder.datareaderapi.service.ReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/read")
public class ReadController {

    private final ReadService readService;

    @Autowired
    public ReadController(ReadService readService){
        this.readService = readService;
    }

    @GetMapping("/{code}")
    public ResponseEntity<ReadResponse> getStates(@PathVariable Integer code){
        try {
            State state = readService.getState(code);
            ReadResponse responseObj =
                    new ReadResponse("", HttpStatus.OK.toString(), Collections.singletonList(state));
            return new ResponseEntity<ReadResponse>(responseObj,HttpStatus.OK);
        }catch (Exception e){
            ReadResponse responseObj = new ReadResponse(e.getMessage(),HttpStatus.NOT_FOUND.toString(), null );
            return new ResponseEntity<ReadResponse>(responseObj,HttpStatus.OK);
        }

    }

    @GetMapping
    public ResponseEntity<ReadResponse> getAllStates(){
        try {
            List<State> allStates = readService.getAllState();
            ReadResponse responseObj = new ReadResponse("",HttpStatus.OK.toString(), allStates);
            return new ResponseEntity<ReadResponse>(responseObj, HttpStatus.OK);
        }catch (Exception e){
            ReadResponse responseObj = new ReadResponse(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR.name(), null );
            return new ResponseEntity<ReadResponse>(responseObj,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
