package com.cd7567.petls.service.mapper;

import com.cd7567.petls.api.Pet;
import com.cd7567.petls.api.CreatePetRequest;
import com.cd7567.petls.entity.PetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

import static org.mapstruct.MappingConstants.ComponentModel.SPRING;

@Mapper(componentModel = SPRING)
public interface PetMapper {

    @Mapping(target = "id", expression = "java(null)")
    @Mapping(target = "kind", source = "kind")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "age", source = "age")
    PetEntity extractPetEntity(CreatePetRequest pet);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "kind", source = "kind")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "age", source = "age")
    Pet toPetDto(PetEntity petEntity);

    List<Pet> toPetDtoList(List<PetEntity> petEntityList);
}
