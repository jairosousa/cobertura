package io.jnsdev.cobertura.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Autor Jairo Nascimento
 * @Created 22/11/2021 - 19:00
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class ContatoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private Integer idade;
}
