package com.pragma.powerup.infrastructure.configuration;

import com.pragma.powerup.domain.api.IEnviarMensajeServicePort;
import com.pragma.powerup.domain.usecase.EnviarMensajeUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    @Bean
    public IEnviarMensajeServicePort enviarMensajeServicePort() {
        return new EnviarMensajeUseCase();
    }

}