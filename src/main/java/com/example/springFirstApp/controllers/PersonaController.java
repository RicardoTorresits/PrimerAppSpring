/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springFirstApp.controllers;

import com.example.springFirstApp.Dto.PersonaDto;
import com.example.springFirstApp.models.Persona;
import com.example.springFirstApp.util.Result;
import java.util.ArrayList;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author it-seekers
 */
@RestController
@RequestMapping("/api")
@Valid()
public class PersonaController {

    List<Persona> personas = new ArrayList<>();

    @GetMapping("/")
    public Result<List<Persona>> getPersonas() {
        personas.add(new Persona(1, "Mariana", "mariana@yopmail.com", 24));
        personas.add(new Persona(2, "Rafa", "rafa@yopmail.com", 24));
        personas.add(new Persona(3, "Daniel", "daniel@yopmail.com", 24));
        personas.add(new Persona(4, "Ricardo", "ricardo@yopmail.com", 27));

        return Result.success(personas, "Personas obtenidas con exito");
    }

    @PostMapping("/create")
    public Result<List<Persona>> createPersona(@Valid @RequestBody PersonaDto PersonaDto){
//        personas.add( persona);
        return ResponseEntity.ok(Result.success(personas, "Personas obtenidas con exito")).getBody();
    }


    @PutMapping("/edit/{id}")
    public Result<List<Persona>> createPersona(@PathVariable Integer id ,@Valid @RequestBody Persona Persona){
        personas.add(new Persona(1, "Mariana", "mariana@yopmail.com", 24));
        personas.add(new Persona(2, "Rafa", "rafa@yopmail.com", 24));
        personas.add(new Persona(3, "Daniel", "daniel@yopmail.com", 24));
        personas.add(new Persona(4, "Ricardo", "ricardo@yopmail.com", 27));

        for (int i = 0; i <= personas.size(); i++) {
            if(personas.get(i).getId() == id){
                personas.set(i,Persona);
                return Result.success(personas, "Personas Actualizada con exito");
            }
        }

        return Result.failure( "Personas no encontrada");
    }

    @DeleteMapping("/delete/{id}")
    public Result<List<Persona>> deletePersona(@PathVariable Integer id){
        personas.add(new Persona(1, "Mariana", "mariana@yopmail.com", 24));
        personas.add(new Persona(2, "Rafa", "rafa@yopmail.com", 24));
        personas.add(new Persona(3, "Daniel", "daniel@yopmail.com", 24));
        personas.add(new Persona(4, "Ricardo", "ricardo@yopmail.com", 27));

        for (int i = 0; i <= personas.size(); i++) {
            if(personas.get(i).getId() == id){
                personas.remove(personas.get(i));
                return Result.success(personas, "Personas Eliminada con exito");
            }
        }

        return Result.failure( "Personas no encontrada");
    }

}
