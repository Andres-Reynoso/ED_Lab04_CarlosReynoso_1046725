package ed.lab;

import java.util.Random;

public class SortingAlgorithms {

    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSortHigh(array, 0, array.length - 1);
    }

    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSortLow(array, 0, array.length - 1);
    }

    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSortRandom(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortHigh(T[] arr, int low, int high) {
        if (low < high) {
            int p = partitionHigh(arr, low, high);
            quickSortHigh(arr, low, p - 1);
            quickSortHigh(arr, p + 1, high);
        }
    }

    private static <T extends Comparable<T>> void quickSortLow(T[] arr, int low, int high) {
        if (low < high) {
            int p = partitionLow(arr, low, high);
            quickSortLow(arr, low, p - 1);
            quickSortLow(arr, p + 1, high);
        }
    }

    private static <T extends Comparable<T>> void quickSortRandom(T[] arr, int low, int high) {
        if (low < high) {
            int p = partitionRandom(arr, low, high);
            quickSortRandom(arr, low, p - 1);
            quickSortRandom(arr, p + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partitionHigh(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                swap(arr, ++i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static <T extends Comparable<T>> int partitionLow(T[] arr, int low, int high) {
        swap(arr, low, high);
        return partitionHigh(arr, low, high);
    }

    private static <T extends Comparable<T>> int partitionRandom(T[] arr, int low, int high) {
        int randomIndex = new Random().nextInt(high - low + 1) + low;
        swap(arr, randomIndex, high);
        return partitionHigh(arr, low, high);
    }

    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
