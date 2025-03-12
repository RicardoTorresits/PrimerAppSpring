package com.example.springFirstApp.Dto;


import com.example.springFirstApp.models.Persona;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;


@JsonIgnoreProperties(ignoreUnknown = false)
public class PersonaDto  {
    private final Integer id;
    private final String name;
    private final String correo;
    private final int edad;


    @JsonCreator
    public PersonaDto(
            @JsonProperty("id") Integer id,
            @JsonProperty("name") String name,
            @JsonProperty("correo") String correo,
            @JsonProperty("edad") int edad) {
        this.id = id;
        this.name = name;
        this.correo = correo;
        this.edad = edad;
    }

    // Getters (no necesitas setters si la clase es inmutable)
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCorreo() {
        return correo;
    }

    public int getEdad() {
        return edad;
    }
}
