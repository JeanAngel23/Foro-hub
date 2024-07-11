package com.example.foro_hub.foro_hub.topic;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name= "topics")
@Entity(name = "Topic")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mensaje;
    @Enumerated(EnumType.STRING)
    private Cursos curso;
    private String titulo;
    private Boolean status;
    private String autor;
    private LocalDateTime fechaCreacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDateTime.now();
        if (!status) {
            status = true; // Valor predeterminado para `status` activo
        }
    }

    public Topic(DatosRegister datosRegister) {
        this.mensaje = datosRegister.mensaje();
        this.curso = datosRegister.nombreCurso();
        this.titulo = datosRegister.titulo();
        this.autor = datosRegister.autor();
        this.status = datosRegister.status();


    }

    public void actualizarDatos(DatosActualizarTopic datosActualizarTopic) {
        if (datosActualizarTopic.mensaje() != null){
            this.mensaje = datosActualizarTopic.mensaje();
        }
        if (datosActualizarTopic.titulo() != null){
            this.titulo = datosActualizarTopic.titulo();
        }
        if (datosActualizarTopic.status() != null) {
            this.status = datosActualizarTopic.status();
        }

    }

    public void desactivarTopic() {
        this.status = false;
    }
}
