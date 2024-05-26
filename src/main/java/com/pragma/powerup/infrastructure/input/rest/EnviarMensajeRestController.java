package com.pragma.powerup.infrastructure.input.rest;

import com.pragma.powerup.application.dto.request.EnviarMensajeRequestDto;
import com.pragma.powerup.application.dto.response.EnviarMensajeResponseDto;
import com.pragma.powerup.application.handler.impl.EnviarMensajeHandler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/msg")
@RequiredArgsConstructor
public class EnviarMensajeRestController {
    private final EnviarMensajeHandler enviarMensajeHandler;

    @Operation(summary = "Envia un mensaje")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Mensaje enviado", content = @Content),
            @ApiResponse(responseCode = "409", description = "El mensaje explotó en el camino", content = @Content)
    })
    @GetMapping("/enviar/{nombre}/{telefono}/{restaurante}")
    public ResponseEntity<EnviarMensajeResponseDto> enviar(@PathVariable String nombre, @PathVariable String telefono, @PathVariable String restaurante) {
        EnviarMensajeRequestDto requestDto = new EnviarMensajeRequestDto();
        requestDto.setNombre(nombre);
        requestDto.setRestaurante(restaurante);
        requestDto.setTelefono(telefono);

        EnviarMensajeResponseDto response = enviarMensajeHandler.enviar(requestDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}
