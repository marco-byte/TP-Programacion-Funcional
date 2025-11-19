package org.example.Entidades;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EmpleadoService {

    // 1. Empleados con salario > 2000, ordenados por salario descendente
    public List<Empleado> obtenerEmpleadosSalarioAlto(List<Empleado> empleados) {
        return empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted((e1, e2) -> Double.compare(e2.getSalario(), e1.getSalario()))
                .collect(Collectors.toList());
    }

    // 2. Salario promedio general
    public double calcularSalarioPromedio(List<Empleado> empleados) {
        return empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0.0);
    }

    // 3. Agrupar empleados por departamento y sumar salarios
    public Map<String, Double> sumarSalariosPorDepartamento(List<Empleado> empleados) {
        return empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));
    }

    // 4. Nombres de los 2 empleados más jóvenes
    public List<String> obtenerNombresEmpleadosJovenes(List<Empleado> empleados) {
        return empleados.stream()
                .sorted((e1, e2) -> Integer.compare(e1.getEdad(), e2.getEdad()))
                .limit(2)
                .map(Empleado::getNombre)
                .collect(Collectors.toList());
    }
}
