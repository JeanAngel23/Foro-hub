package com.example.foro_hub.foro_hub.topic;

import jakarta.validation.constraints.NotNull;

public record DatosActualizarTopic(@NotNull Long id, String mensaje, String titulo, Boolean status) {
}
