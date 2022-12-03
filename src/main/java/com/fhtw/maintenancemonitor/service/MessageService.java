package com.fhtw.maintenancemonitor.service;

import com.fhtw.maintenancemonitor.exception.MessageException;
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
    public void setMessage(String message) throws MessageException {
        if (message != null && !message.isEmpty()){
            this.message = message;
        }else {
            throw new MessageException("Message can not be empty");
        }
    }

}
