package com.cd7567.petls.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.hibernate.validator.constraints.Length;

public class Pet {

    @JsonProperty("id")
    @NotNull
    @Positive
    private Long id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
