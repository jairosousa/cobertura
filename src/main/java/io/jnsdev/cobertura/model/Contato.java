package io.jnsdev.cobertura.model;

import lombok.*;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;

/**
 * @Autor Jairo Nascimento
 * @Created 22/11/2021 - 19:05
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode(callSuper = false)
public class Contato extends RepresentationModel<Contato> implements Serializable {
    private Long id;
    private String nome;
    private Integer idade;
}
