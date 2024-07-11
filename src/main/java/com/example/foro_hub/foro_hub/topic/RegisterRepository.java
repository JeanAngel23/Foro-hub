package com.example.foro_hub.foro_hub.topic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository <Topic,Long>{
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Page<Topic> findByStatusTrue(Pageable pageable);

}
