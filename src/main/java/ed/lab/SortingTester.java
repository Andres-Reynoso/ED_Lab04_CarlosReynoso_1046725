package ed.lab;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingTester<T extends Comparable<T>> {

    private static final int ARRAY_SIZE = 10000;
    private static final int TEST_SIZE = 1000;

    public void testSorting(ArrayGenerator<T> generator, QuickSort<T> quickSort) {

        // Generar el arreglo base
        T[] array = generator.generate(ARRAY_SIZE);

        // Lista para almacenar las duraciones de cada ejecución
        List<Duration> durations = new ArrayList<>(TEST_SIZE);

        // Ejecutar múltiples pruebas de ordenamiento
        for (int i = 0; i < TEST_SIZE; i++) {

            // Copiar el arreglo para no modificar el original
            T[] copy = Arrays.copyOf(array, array.length);

            // Medir tiempo de inicio
            LocalDateTime start = LocalDateTime.now();

            // Ejecutar QuickSort
            quickSort.sort(copy);

            // Medir tiempo de finalización
            LocalDateTime end = LocalDateTime.now();

            // Calcular y almacenar la duración
            durations.add(Duration.between(start, end));
        }

        // Calcular el tiempo promedio usando Streams
        double average = durations.stream()
                .mapToLong(Duration::toMillis)
                .average()
                .orElse(0);

        // Calcular la sumatoria total de los tiempos usando Streams
        long sum = durations.stream()
                .mapToLong(Duration::toMillis)
                .sum();

        // Mostrar resultados
        System.out.printf("\t\tTiempo promedio: %.2f ms%n", average);
        System.out.println("\t\tSumatoria de tiempo: " + sum + " ms");
    }
}
