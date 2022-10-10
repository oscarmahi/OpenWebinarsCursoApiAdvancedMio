package com.openwebinars.rest.error;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Clase POJO para personalizar nuestros errores. Se devuelve en formato Json
 */
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class ApiError {

    @NonNull
    private HttpStatus estado;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy hh:mm:ss")
    private LocalDateTime fecha = LocalDateTime.now();

    @NonNull
    private String mensaje;

}
