package com.pragma.powerup.domain.usecase;

import com.pragma.powerup.domain.api.IEnviarMensajeServicePort;
import com.pragma.powerup.infrastructure.configuration.TwilioConfig;
import com.pragma.powerup.infrastructure.out.jpa.adapter.EnviarMensajeAdapter;

public class EnviarMensajeUseCase implements IEnviarMensajeServicePort {


    @Override
    public boolean enviar(String telefono, String body) {
        return new EnviarMensajeAdapter(new TwilioConfig()).enviar(telefono, body);
    }
}
