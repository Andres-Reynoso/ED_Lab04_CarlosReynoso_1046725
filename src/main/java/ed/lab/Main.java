package ed.lab;

public class Main {

    private static final ArrayGenerator<Integer> sortedArrayGenerator =
            (length) -> {
                Integer[] array = new Integer[length];
                for (int i = 0; i < length; i++) {
                    array[i] = i;
                }
                return array;
            };

    private static final ArrayGenerator<Integer> invertedArrayGenerator =
            (length) -> {
                Integer[] array = new Integer[length];
                for (int i = 0; i < length; i++) {
                    array[i] = length - 1 - i;
                }
                return array;
            };

    private static final ArrayGenerator<Integer> randomArrayGenerator =
            (length) -> {
                Integer[] array = new Integer[length];
                for (int i = 0; i < length; i++) {
                    array[i] = (int) (Math.random() * length);
                }
                return array;
            };

    private static final QuickSort<Integer> highPivotQuickSort = QuickSort::highPivotQuickSort;
    private static final QuickSort<Integer> lowPivotQuickSort = QuickSort::lowPivotQuickSort;
    private static final QuickSort<Integer> randomPivotQuickSort = QuickSort::randomPivotQuickSort;

    public static void main(String[] args) {
        SortingTester<Integer> tester = new SortingTester<>();

        tester.testSorting(sortedArrayGenerator, highPivotQuickSort);
        tester.testSorting(sortedArrayGenerator, lowPivotQuickSort);
        tester.testSorting(sortedArrayGenerator, randomPivotQuickSort);

        tester.testSorting(invertedArrayGenerator, highPivotQuickSort);
        tester.testSorting(invertedArrayGenerator, lowPivotQuickSort);
        tester.testSorting(invertedArrayGenerator, randomPivotQuickSort);

        tester.testSorting(randomArrayGenerator, highPivotQuickSort);
        tester.testSorting(randomArrayGenerator, lowPivotQuickSort);
        tester.testSorting(randomArrayGenerator, randomPivotQuickSort);
    }
}
