package com.fhtw.maintenancemonitor.web;


import com.fhtw.maintenancemonitor.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "/api/message")
    public ResponseEntity<String> getMessage() {
        return ResponseEntity.ok(messageService.getMessage());
    }

    @PutMapping(value = "/api/message/reset")
    public ResponseEntity<Object> resetMessage() {
        messageService.resetMessage();
        return ResponseEntity.ok().build();
    }




}
