package com.example.foro_hub.foro_hub.topic;

import java.time.LocalDateTime;

public record DatosListadoTopic(
        Long id,
        String mensaje,
        Cursos curso,
        String titulo,
        LocalDateTime fechaCreacion

) {
    public DatosListadoTopic(Topic topic){
        this(topic.getId() ,topic.getMensaje(),topic.getCurso() , topic.getTitulo(), topic.getFechaCreacion());
    }
}
