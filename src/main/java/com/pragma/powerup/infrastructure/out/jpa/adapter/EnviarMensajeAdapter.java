package com.pragma.powerup.infrastructure.out.jpa.adapter;

import com.pragma.powerup.infrastructure.configuration.TwilioConfig;
import org.springframework.stereotype.Service;

@Service
public class EnviarMensajeAdapter {

    private final TwilioConfig twilioConfig;

    public EnviarMensajeAdapter(TwilioConfig twilioConfig) {
        this.twilioConfig = twilioConfig;
    }

    public boolean enviar(String telefono, String contenido) {
        try {
            twilioConfig.sendMessage(telefono, contenido);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
