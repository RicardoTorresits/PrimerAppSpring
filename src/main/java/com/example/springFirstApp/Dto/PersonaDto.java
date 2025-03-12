package com.example.springFirstApp.Dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import org.springframework.lang.NonNull;

public class PersonaDto {
    @NonNull(message = "El ID no puede ser nulo")
    private Integer id;

    @NonNull(message = "El nombre no puede estar vacío")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;

    @Email(message = "El correo debe ser válido")
    private String email;

    @NonNull (message = "la edad no puede ser vacia")
    private int edad;

    public PersonaDto() {
    }

    public PersonaDto(@NonNull Integer id, @NonNull String name, String email, int edad) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.edad = edad;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
