package com.fhtw.maintenancemonitor.web;


import com.fhtw.maintenancemonitor.exception.MessageException;
import com.fhtw.maintenancemonitor.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {

    private final MessageService messageService;
    private String messageStyle =  "<body style=\"background-color: #DBF4E4\"><h1 style=\"display: flex; height: 200px;align-items: center;justify-content: center; \">";
    //private String messageStyle =  "";
    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @RequestMapping(value = "/api/message")
    public ResponseEntity<String> getMessage() {

        return ResponseEntity.ok(messageStyle + messageService.getMessage());
    }

    @RequestMapping(value = "/api/message/reset")
    public ResponseEntity<Object> resetMessage() {
        messageService.resetMessage();
        messageStyle =  "<body style=\"background-color: #DBF4E4\"><h1 style=\"display: flex; height: 200px;align-items: center;justify-content: center; \">";
        return ResponseEntity.ok(messageStyle + "Message reset");
    }



    @GetMapping(value = "/api/message/set")
    public ResponseEntity<Object> setMessage(@RequestParam(value = "m") String message) {
        try {
            messageService.setMessage(message);
            messageStyle =  "<body style=\"background-color: #FFCC99\"><h1 style=\"display: flex; height: 200px;align-items: center;justify-content: center; \">";
            return ResponseEntity.ok(messageStyle + "Message set to \"" + message+"\"");
        } catch (MessageException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
