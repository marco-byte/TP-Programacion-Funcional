package org.example.Entidades;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LibroService {

    // 1. Títulos de libros con más de 300 páginas, ordenados alfabéticamente
    public List<String> obtenerTitulosLibrosLargos(List<Libro> libros) {
        return libros.stream()
                .filter(l -> l.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());
    }

    // 2. Promedio de páginas de todos los libros
    public double calcularPromedioPaginas(List<Libro> libros) {
        return libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0.0);
    }

    // 3. Agrupar libros por autor y contar cuántos tiene cada uno
    public Map<String, Long> contarLibrosPorAutor(List<Libro> libros) {
        return libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting()
                ));
    }

    // 4. Obtener el libro más caro
    public Libro obtenerLibroMasCaro(List<Libro> libros) {
        return libros.stream()
                .max((l1, l2) -> Double.compare(l1.getPrecio(), l2.getPrecio()))
                .orElse(null);
    }
}
