package com.pragma.powerup.application.handler.impl;

import com.pragma.powerup.application.dto.request.EnviarMensajeRequestDto;
import com.pragma.powerup.application.dto.response.EnviarMensajeResponseDto;
import com.pragma.powerup.application.handler.IEnviarMensajeHandler;
import com.pragma.powerup.domain.api.IEnviarMensajeServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor

public class EnviarMensajeHandler implements IEnviarMensajeHandler {

    private final IEnviarMensajeServicePort enviarMensajeServicePort;

    @Override
    public EnviarMensajeResponseDto enviar(EnviarMensajeRequestDto enviarMensajeRequestDto) {

        String pin = generarPIN(6);

        String body = "Hola, querido " +
                enviarMensajeRequestDto.getNombre() +
                ". Le informamos que su pedido del restaurante " +
                enviarMensajeRequestDto.getRestaurante() +
                " ya se encuentra listo para su despacho. Recuerde utilizar el siguiente PIN al recibirlo:"
                + pin;

        boolean response = enviarMensajeServicePort.enviar(enviarMensajeRequestDto.getTelefono(), body);

        EnviarMensajeResponseDto responseDto = new EnviarMensajeResponseDto();
        responseDto.setEnviado(response);
        responseDto.setPin(pin);

        return responseDto;
    }

    private static String generarPIN(int longitud) {
        Random random = new Random();

        StringBuilder pinBuilder = new StringBuilder();

        for (int i = 0; i < longitud; i++) {
            int digito = random.nextInt(10);
            pinBuilder.append(digito);
        }
        return pinBuilder.toString();
    }
}
