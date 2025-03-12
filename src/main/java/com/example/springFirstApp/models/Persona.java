/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.springFirstApp.models;

/**
 *
 * @author it-seekers
 */
public class Persona {
    private int id;
    private String name;
    private String correo;
    private int edad;

    public Persona() {
    }

    public Persona(int id, String name, String correo, int edad) {
        this.id = id;
        this.name = name;
        this.correo = correo;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}
