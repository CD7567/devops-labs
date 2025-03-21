package com.cd7567.petls.resource;

import com.cd7567.petls.api.GetPetListResult;
import com.cd7567.petls.api.CreatePetRequest;
import com.cd7567.petls.api.common.BaseResponse;
import com.cd7567.petls.service.PetService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class PetResource {

    private final PetService petService;


    @Autowired
    public PetResource(PetService petService) {
        this.petService = petService;
    }


    @PostMapping(
            value = "/createPet",
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE
    )
    public BaseResponse<Void> createPet(
            @RequestBody @Valid
            CreatePetRequest createPetRequest
    ) {
        petService.createPet(createPetRequest);
        return BaseResponse.wrap(null);
    }

    @GetMapping(
            value = "/getPetList",
            produces = APPLICATION_JSON_VALUE
    )
    public BaseResponse<GetPetListResult> getPetList() {
        return BaseResponse.wrap(petService.getPetList());
    }
}
