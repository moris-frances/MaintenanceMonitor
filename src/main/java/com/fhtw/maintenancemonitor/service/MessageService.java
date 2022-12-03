package com.fhtw.maintenancemonitor.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService{
    private String message;

    public String getMessage(){
        String defaultMessage = "Everything works as expected";
        return  (message != null && !message.isEmpty()) ? message : defaultMessage;
    }

    public void resetMessage(){
        this.message = null;
    }


}
