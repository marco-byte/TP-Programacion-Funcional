package org.example.Entidades;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductoService {

    public List<Producto> obtenerProductosCaros(List<Producto> productos) {
        return productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted((p1, p2) -> Double.compare(p2.getPrecio(), p1.getPrecio()))
                .collect(Collectors.toList());
    }

    public Map<String, Integer> calcularStockPorCategoria(List<Producto> productos) {
        return productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)
                ));
    }

    public String generarStringProductos(List<Producto> productos) {
        return productos.stream()
                .map(p -> p.getNombre() + ";" + p.getPrecio())
                .collect(Collectors.joining(";"));
    }

    public double calcularPromedioGeneral(List<Producto> productos) {
        return productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0.0);
    }

    public Map<String, Double> calcularPromedioPorCategoria(List<Producto> productos) {
        return productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));
    }
}
