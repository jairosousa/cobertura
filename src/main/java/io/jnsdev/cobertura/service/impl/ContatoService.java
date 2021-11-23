package io.jnsdev.cobertura.service.impl;

import io.jnsdev.cobertura.controller.ContatoController;
import io.jnsdev.cobertura.mapper.ContatoMapper;
import io.jnsdev.cobertura.model.Contato;
import io.jnsdev.cobertura.model.ContatoEntity;
import io.jnsdev.cobertura.model.ContatoRef;
import io.jnsdev.cobertura.repository.ContatoRepository;
import io.jnsdev.cobertura.service.IContatoService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Autor Jairo Nascimento
 * @Created 22/11/2021 - 19:36
 */
@Service
@AllArgsConstructor
public class ContatoService implements IContatoService {

    private final ContatoRepository repository;
    private final ContatoMapper mapper;


    @Override
    public List<Contato> getAllContatos() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Contato getStudentById(Long contatoId) {
        Optional<ContatoEntity> entity = repository.findById(contatoId);
        if (entity.isPresent()) {
            Contato contato = mapper.toDto(entity.get());
            //adding hateoas links to student object
            final Link selfLink = WebMvcLinkBuilder.linkTo(ContatoController.class).slash(contato.getId()).withSelfRel();
            contato.add(selfLink);

            return contato;

        }
            return null;
    }

    @Override
    public Contato createContact(Contato contato) {
        ContatoEntity contatoEntity = repository.save(mapper.toEntity(contato));
        return mapper.toDto(contatoEntity);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<ContatoRef> getAllContatosRefList() {
        List<ContatoEntity> entities = this.getAllContatos()
                .stream().map(mapper::toEntity)
                .collect(Collectors.toList());

        if (!CollectionUtils.isEmpty(entities)) {
            List<ContatoRef> contatoRefs = this.mapper.toDtoRefList(entities);

            //adding hateoas links to each object in studentRefList
            contatoRefs.forEach(contatoRef -> {
                final Link selfLink = WebMvcLinkBuilder.linkTo(ContatoController.class).slash(contatoRef.getId()).withSelfRel();
                contatoRef.add(selfLink);
            });
            return contatoRefs;
        }

        return Collections.emptyList();
    }
}
