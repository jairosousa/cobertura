package io.jnsdev.cobertura.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

/**
 * @Autor Jairo Nascimento
 * @Created 22/11/2021 - 20:27
 */
@Getter
@Setter
public class ContatoRef extends RepresentationModel<ContatoRef> implements Serializable {
    private Long id;
}
