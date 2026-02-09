package ed.lab;

public class Main {

    private static final ArrayGenerator<String> sortedArrayGenerator =
            length -> {
                String[] array = new String[length];
                for (int i = 0; i < length; i++) {
                    array[i] = String.format("%05d", i);
                }
                return array;
            };

    private static final ArrayGenerator<String> invertedArrayGenerator =
            length -> {
                String[] array = new String[length];
                for (int i = 0; i < length; i++) {
                    array[i] = String.format("%05d", length - 1 - i);
                }
                return array;
            };

    private static final ArrayGenerator<String> randomArrayGenerator =
            length -> {
                String[] array = new String[length];
                for (int i = 0; i < length; i++) {
                    array[i] = String.format("%05d", (int) (Math.random() * length));
                }
                return array;
            };

    private static final QuickSort<String> highPivotQuickSort =
            SortingAlgorithms::highPivotQuickSort;

    private static final QuickSort<String> lowPivotQuickSort =
            SortingAlgorithms::lowPivotQuickSort;

    private static final QuickSort<String> randomPivotQuickSort =
            SortingAlgorithms::randomPivotQuickSort;

    public static void main(String[] args) {

        SortingTester<String> tester = new SortingTester<>();

        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
    }
}
