package io.jnsdev.cobertura.mapper;

import io.jnsdev.cobertura.model.Contato;
import io.jnsdev.cobertura.model.ContatoEntity;
import io.jnsdev.cobertura.model.ContatoRef;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Objects;

/**
 * @Autor Jairo Nascimento
 * @Created 22/11/2021 - 19:08
 */
@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
@MapperConfig(unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.ERROR)
public interface ContatoMapper {

    ContatoMapper INSTANCE = Mappers.getMapper(ContatoMapper.class);

    @Mappings({
            @Mapping(target = "id", ignore = true)
    })
    ContatoEntity toEntity(Contato contato);

    Contato toDto(ContatoEntity entity);

    List<ContatoEntity> toEntityList(List<Contato> studentList);

    List<Contato> toDtoList(List<ContatoEntity> studentEntityList);

    @BeanMapping(ignoreUnmappedSourceProperties = {"nome", "idade"})
    ContatoRef toDtoRef(ContatoEntity studentEntity);

    List<ContatoRef> toDtoRefList(List<ContatoEntity> studentEntityList);

    @AfterMapping
    default void setEntityId(Contato contato, @MappingTarget ContatoEntity contatoEntity) {
        if(Objects.nonNull(contato.getId()))
            contatoEntity.setId(contato.getId());
    }
}
