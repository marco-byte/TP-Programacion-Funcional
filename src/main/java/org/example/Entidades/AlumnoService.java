package org.example.Entidades;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AlumnoService {

    public List<String> obtenerNombresAprobados(List<Alumno> alumnos) {
        return alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());
    }

    public double calcularPromedioGeneral(List<Alumno> alumnos) {
        return alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0.0);
    }

    public Map<String, List<Alumno>> agruparPorCurso(List<Alumno> alumnos) {
        return alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));
    }

    public List<Double> obtenerTresMejoresPromedios(List<Alumno> alumnos) {
        return alumnos.stream()
                .sorted((a1, a2) -> Double.compare(a2.getNota(), a1.getNota()))
                .limit(3)
                .map(Alumno::getNota)
                .collect(Collectors.toList());
    }
}
