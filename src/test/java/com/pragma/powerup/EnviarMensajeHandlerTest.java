package com.pragma.powerup;

import com.pragma.powerup.application.dto.request.EnviarMensajeRequestDto;
import com.pragma.powerup.application.dto.response.EnviarMensajeResponseDto;
import com.pragma.powerup.application.handler.impl.EnviarMensajeHandler;
import com.pragma.powerup.domain.api.IEnviarMensajeServicePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EnviarMensajeHandlerTest {

    @Mock
    private IEnviarMensajeServicePort enviarMensajeServicePort;

    private EnviarMensajeHandler handler;

    @BeforeEach
    void setUp() {

        handler = new EnviarMensajeHandler(enviarMensajeServicePort);
    }

    @Test
    void enviar() {

        EnviarMensajeRequestDto requestDto = new EnviarMensajeRequestDto();
        requestDto.setNombre("Juan");
        requestDto.setTelefono("+573022074060");
        requestDto.setRestaurante("Pizzaa");
        when(enviarMensajeServicePort.enviar(anyString(), anyString())).thenReturn(true);


        EnviarMensajeResponseDto responseDto = handler.enviar(requestDto);


        assertNotNull(responseDto);
        assertTrue(responseDto.isEnviado());
        assertNotNull(responseDto.getPin());
        assertEquals(6, responseDto.getPin().length());
    }
}