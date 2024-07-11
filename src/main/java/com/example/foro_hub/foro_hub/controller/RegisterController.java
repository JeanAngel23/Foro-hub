package com.example.foro_hub.foro_hub.controller;

import com.example.foro_hub.foro_hub.service.TopicService;
import com.example.foro_hub.foro_hub.topic.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topicos")
public class RegisterController {

    private final RegisterRepository registerRepository;
    private final TopicService topicService;

    public RegisterController(RegisterRepository registerRepository, TopicService topicService){
        this.registerRepository = registerRepository;
        this.topicService = topicService;
    }

    @PostMapping
    public ResponseEntity<DatosRespuestaTopic> registrarUsuario(@RequestBody @Valid DatosRegister datosRegister, UriComponentsBuilder uriComponentsBuilder){
        topicService.validarTopic(datosRegister);
        Topic topic = registerRepository.save(new Topic(datosRegister));
        DatosRespuestaTopic datosRespuestaTopic =new DatosRespuestaTopic(topic.getId(), topic.getMensaje(),topic.getCurso()
                , topic.getTitulo(), topic.getAutor());
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopic);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopic>>listadoTopics(@PageableDefault(size = 10, sort = "titulo", direction = Sort.Direction.ASC)Pageable pageable){
        return ResponseEntity.ok(registerRepository.findByStatusTrue(pageable).map(DatosListadoTopic::new));
    }
    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopic> retornaDatosMedico(@PathVariable Long id){
        Topic topic = registerRepository.getReferenceById(id);
        var datosMedico = new DatosRespuestaTopic(topic.getId(), topic.getMensaje(),topic.getCurso()
                , topic.getTitulo(), topic.getAutor());
        return ResponseEntity.ok(datosMedico);

    }


// Retornamos la actualizacion del cliente
    @PutMapping
    @Transactional
    public ResponseEntity actualizarTopic (@RequestBody @Valid DatosActualizarTopic datosActualizarTopic){
        Topic topic = registerRepository.getReferenceById(datosActualizarTopic.id());
        topic.actualizarDatos(datosActualizarTopic);
        return ResponseEntity.ok(new DatosRespuestaTopic(topic.getId(), topic.getMensaje(),topic.getCurso()
                , topic.getTitulo(), topic.getAutor()
                ));

    }
//Delete logico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopic(@PathVariable Long id){
        Topic topic = registerRepository.getReferenceById(id);
        topic.desactivarTopic();
        return ResponseEntity.noContent().build();

    }
}
