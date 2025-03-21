/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springFirstApp.controllers;

import com.example.springFirstApp.Dto.PersonaDto;
import com.example.springFirstApp.models.Persona;
import com.example.springFirstApp.service.PersonaService;
import com.example.springFirstApp.util.Result;

import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author it-seekers
 */
@Controller
@RequestMapping("/api")
@Valid()
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String getPersonas(Model model) {

        model.addAttribute("personas",
                personaService.getPersonas());
        return "listaPersonas";
    }

   @GetMapping("/create")
    public String viewFromCreatePersona(Model model) {
        model.addAttribute("persona", new Persona());
        return "formularioPersona";
   }

   @PostMapping("/create")
    public String createpersona(@Valid @ModelAttribute("persona") Persona persona) {
        personaService.addPersona(persona);
        return "redirect:/api/";
   }

   @GetMapping("/editar/{id}")
    public String viewFromEditPersona(Model model, @PathVariable int id) {
        model.addAttribute("persona", personaService.getPersona(id));
        return"formularioPersona";
   }

   @PostMapping("/editar")
    public String editpersona(@Valid @ModelAttribute("persona") Persona persona) {
        personaService.actualizarPersona(persona);
        return "redirect:/api/";
   }

   @GetMapping("/eliminar/{id}")
    public String eliminarPersona(Model model, @PathVariable int id) {
        personaService.deletePersona(id);
        return "redirect:/api/";
   }

}
