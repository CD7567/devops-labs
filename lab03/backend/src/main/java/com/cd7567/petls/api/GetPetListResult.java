package com.cd7567.petls.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class GetPetListResult {

    @JsonProperty("pets")
    @NotNull
    private List<Pet> pets;


    public GetPetListResult(List<Pet> pets) {
        this.pets = pets;
    }


    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
