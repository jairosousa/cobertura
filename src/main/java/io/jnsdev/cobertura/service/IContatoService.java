package io.jnsdev.cobertura.service;

import io.jnsdev.cobertura.model.Contato;
import io.jnsdev.cobertura.model.ContatoRef;

import java.util.List;

/**
 * @Autor Jairo Nascimento
 * @Created 22/11/2021 - 19:25
 */
public interface IContatoService {
    /**
     * get all contacts refs in the database
     *
     * @return List<Contato>
     */
    List<Contato> getAllContatos();

    /**
     * get a specific contact from the database
     *
     * @param contatoId
     * @return Contato
     */
    Contato getStudentById(Long contatoId);

    /**
     * create a Contact instance in the database
     *
     * @param contato
     * @return Contato
     */
    Contato createContact(Contato contato);

    List<ContatoRef> getAllContatosRefList();

}
