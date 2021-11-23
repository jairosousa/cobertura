package io.jnsdev.cobertura.controller;

import io.jnsdev.cobertura.model.Contato;
import io.jnsdev.cobertura.model.ContatoRef;
import io.jnsdev.cobertura.service.impl.ContatoService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @Autor Jairo Nascimento
 * @Created 22/11/2021 - 18:38
 */

@RestController
@RequestMapping(value = "contacts", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ContatoController {

    private final ContatoService service;

    @PostMapping
    public ResponseEntity<Contato> save(@RequestBody Contato contato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createContact(contato));
    }

    @GetMapping
    public ResponseEntity<CollectionModel<ContatoRef>> getAllContatos() {
        List<ContatoRef> contatos = service.getAllContatosRefList();
        CollectionModel<ContatoRef> contatoRefs = null;
        if (!CollectionUtils.isEmpty(contatos)) {
            final Link link = WebMvcLinkBuilder.linkTo(
                    WebMvcLinkBuilder.methodOn(ContatoController.class)
                    .getAllContatos()).withSelfRel();
            contatoRefs = CollectionModel.of(contatos, link);
        }

        return Optional.ofNullable(contatoRefs)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(value = "/{contatoId}")
    ResponseEntity<Contato> getStudentById(@PathVariable final Long contatoId) {
        final Contato contato = this.service.getStudentById(contatoId);

        return Optional.ofNullable(contato)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
