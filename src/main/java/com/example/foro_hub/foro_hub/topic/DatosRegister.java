package com.example.foro_hub.foro_hub.topic;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegister(
        @NotBlank(message = "El mensaje es obligatorio")
        String mensaje,
        @NotNull(message = "El curso es obligatorio")
        Cursos nombreCurso ,
        @NotBlank(message = "El título es obligatorio")
        String titulo,
        @NotBlank(message = "No hay un autor")
        String autor,
        Boolean status) {
}
