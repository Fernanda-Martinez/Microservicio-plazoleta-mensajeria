package com.pragma.powerup.infrastructure.configuration;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TwilioConfig {

    @PostConstruct
    public void initTwilio() {
        String accountSid = "AC114c8785ece6a3e0c8a347cd6455ede5";
        String authToken = "4b253ba7376a81f4c84deac665e82738";
        Twilio.init(accountSid, authToken);
    }

    public void sendMessage(String to, String body) {
        String twilioPhoneNumber = "+18285190618";
        Message message = Message.creator(
                new PhoneNumber(to),
                new PhoneNumber(twilioPhoneNumber),
                body
        ).create();

    }
}

