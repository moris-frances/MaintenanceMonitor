package com.fhtw.maintenancemonitor.web;

import com.fhtw.maintenancemonitor.pojo.Monitor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MonitorController {

    @GetMapping(value = "/api/message")
    public ResponseEntity<Monitor> getMessage() {
        Monitor monitor; // just for now will
        return new ResponseEntity<>(monitor, HttpStatus.OK); //
    }

    @PostMapping(value = "/api/message/set")
    public ResponseEntity<Monitor> createMessage(@RequestBody Monitor monitor) {
        //contactService.saveContact(contact); // just for now will
        return new ResponseEntity<>(monitor, HttpStatus.CREATED); // // just for now will
    }
}
