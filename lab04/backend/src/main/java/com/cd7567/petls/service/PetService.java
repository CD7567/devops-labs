package com.cd7567.petls.service;

import com.cd7567.petls.api.GetPetListResult;
import com.cd7567.petls.api.Pet;
import com.cd7567.petls.api.CreatePetRequest;
import com.cd7567.petls.entity.PetEntity;
import com.cd7567.petls.repository.PetRepository;
import com.cd7567.petls.service.mapper.PetMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    private final PetRepository petRepository;

    private final PetMapper petMapper;


    @Autowired
    public PetService(PetRepository petRepository, PetMapper petMapper) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }


    @Transactional
    public void createPet(CreatePetRequest createPetRequest) {
        PetEntity newPet = petMapper.extractPetEntity(createPetRequest);
        petRepository.save(newPet);
    }

    @Transactional
    public GetPetListResult getPetList() {
        List<Pet> petList = petMapper.toPetDtoList(petRepository.findAll());
        return new GetPetListResult(petList);
    }
}
