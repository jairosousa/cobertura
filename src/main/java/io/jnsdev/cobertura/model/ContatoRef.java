package io.jnsdev.cobertura.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

/**
 * @Autor Jairo Nascimento
 * @Created 22/11/2021 - 20:27
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString
public class ContatoRef extends RepresentationModel<ContatoRef> implements Serializable {
    private Long id;
}
