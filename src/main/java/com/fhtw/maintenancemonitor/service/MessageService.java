package com.fhtw.maintenancemonitor.service;

import com.fhtw.maintenancemonitor.exception.MessageException;
import org.springframework.stereotype.Service;

@Service
public class MessageService{
    private String message = null;
    private String defaultMessage = "Everything works as expected";

    public String getMessage(){

        if(message != null && !message.isEmpty()){
            return message;
        }
        return defaultMessage;
    }

    public void resetMessage(){

        this.message = this.defaultMessage;
    }
    public void setMessage(String message) throws MessageException {
        if (message != null && !message.isEmpty()){
            this.message = message;
        }else {
            throw new MessageException("Message can not be empty");
        }
    }

}
