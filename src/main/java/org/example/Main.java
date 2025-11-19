package org.example;

import org.example.Entidades.*;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        // --- Pruebas para Libro ---
        List<Libro> libros = Arrays.asList(
                new Libro("El Quijote", "Cervantes", 863, 25.99),
                new Libro("1984", "Orwell", 328, 15.50),
                new Libro("Cien años de soledad", "García Márquez", 417, 20.00)
        );

        LibroService libroService = new LibroService();
        System.out.println("Títulos de libros largos: " + libroService.obtenerTitulosLibrosLargos(libros));
        System.out.println("Promedio de páginas: " + libroService.calcularPromedioPaginas(libros));
        System.out.println("Libros por autor: " + libroService.contarLibrosPorAutor(libros));
        System.out.println("Libro más caro: " + libroService.obtenerLibroMasCaro(libros).getTitulo());

        // --- Pruebas para Empleado ---
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Ana", "Ventas", 2500.0, 30),
                new Empleado("Luis", "TI", 3000.0, 25),
                new Empleado("Carlos", "Ventas", 1800.0, 40)
        );

        EmpleadoService empleadoService = new EmpleadoService();
        System.out.println("Empleados con salario alto: " + empleadoService.obtenerEmpleadosSalarioAlto(empleados));
        System.out.println("Salario promedio: " + empleadoService.calcularSalarioPromedio(empleados));
        System.out.println("Suma de salarios por departamento: " + empleadoService.sumarSalariosPorDepartamento(empleados));
        System.out.println("2 empleados más jóvenes: " + empleadoService.obtenerNombresEmpleadosJovenes(empleados));
    }
}
