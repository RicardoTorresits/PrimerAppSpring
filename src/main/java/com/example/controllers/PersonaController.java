/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controllers;

import com.example.models.Persona;
import com.example.util.Result;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author it-seekers
 */
@RestController
@RequestMapping("/api")
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

}
