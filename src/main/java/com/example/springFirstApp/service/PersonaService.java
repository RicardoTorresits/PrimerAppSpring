package com.example.springFirstApp.service;
import com.example.springFirstApp.models.Persona;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonaService {

    private List<Persona> personas = new ArrayList<>();
    private int nextId = 1;

    public  List<Persona> getPersonas() {
        return personas;
    }

    public Persona getPersona(int id) {
        Map<Integer, Persona> personasIndexadas = personas.stream()
                .reduce(
                        new HashMap<>(),  // Acumulador inicial
                        (acc, persona) -> { // Acumulador que llena el Map
                            acc.put(persona.getId(), persona);
                            return acc;
                        },
                        (map1, map2) -> { // Combina mapas (en caso de ejecución paralela)
                            map1.putAll(map2);
                            return map1;
                        }
                );

        if (!personasIndexadas.containsKey(id)) {
            throw new NoSuchElementException("Persona con ID " + id + " no encontrada");
        }

        return personasIndexadas.get(id);
    }

    public void addPersona(Persona persona) {
        persona.setId(nextId++);
        personas.add(persona);
    }

    public void actualizarPersona(Persona personaActializada) {
        personas.removeIf( persona -> persona.getId() == personaActializada.getId() );
        personas.add(personaActializada);
    }

    public void deletePersona(int id) {
        personas.removeIf( persona -> persona.getId() == id );

    }

}
