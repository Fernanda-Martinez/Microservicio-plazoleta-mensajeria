package com.pragma.powerup.application.handler;

import com.pragma.powerup.application.dto.request.EnviarMensajeRequestDto;
import com.pragma.powerup.application.dto.response.EnviarMensajeResponseDto;

public interface IEnviarMensajeHandler {
    EnviarMensajeResponseDto enviar(EnviarMensajeRequestDto enviarMensajeRequestDto);
}
