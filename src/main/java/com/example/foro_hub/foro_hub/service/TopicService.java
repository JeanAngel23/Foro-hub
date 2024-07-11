package com.example.foro_hub.foro_hub.service;

import com.example.foro_hub.foro_hub.topic.DatosRegister;
import com.example.foro_hub.foro_hub.topic.RegisterRepository;
import com.example.foro_hub.foro_hub.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private RegisterRepository registerRepository;

    public void validarTopic(DatosRegister datosRegister){
        if (registerRepository.existsByTituloAndMensaje(datosRegister.titulo(), datosRegister.mensaje())){
            throw new RuntimeException("Ya existe un topico con el mismo titulo y mensaje");
        }
        Topic topic = new Topic(datosRegister);
        registerRepository.save(topic);
    }


}


