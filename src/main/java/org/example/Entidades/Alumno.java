package org.example.Entidades;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Alumno {
    private String nombre;
    private double nota;
    private String curso;

    public Alumno(String nombre, double nota, String curso) {
        this.nombre = nombre;
        this.nota = nota;
        this.curso = curso;
    }

    // Getters
    public String getNombre() { return nombre; }
    public double getNota() { return nota; }
    public String getCurso() { return curso; }
}
