package com.cd7567.petls.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Length;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreatePetRequest {

    @JsonProperty("kind")
    @NotBlank
    @Length(max = 64)
    private String kind;

    @JsonProperty("name")
    @NotBlank
    @Length(max = 64)
    private String name;

    @JsonProperty("age")
    @NotNull
    @PositiveOrZero
    private Integer age;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
