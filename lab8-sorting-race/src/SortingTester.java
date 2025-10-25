import java.util.Arrays;
import java.util.Random;

public class SortingTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 25000, 50000, 100000};

        System.out.println("--- The Sorting Race ---");

        for (int n : sizes) {
            System.out.println("\n--- Testing for array size n = " + n + " ---");

            int[] average = generateRandomArray(n);
            int[] best = generateSortedArray(n);
            int[] worst = generateReverseSortedArray(n);

            runAndTimeAllSorts(average.clone(), "Average Case");
            runAndTimeAllSorts(best.clone(), "Best Case");
            runAndTimeAllSorts(worst.clone(), "Worst Case");
        }
    }

    public static void runAndTimeAllSorts(int[] arr, String caseType) {
        System.out.println("\n" + caseType + ":");

        int[] arr1 = arr.clone();
        long start = System.nanoTime();
        SortingAlgorithms.selectionSort(arr1);
        long end = System.nanoTime();
        System.out.println("Selection Sort time: " + (end - start) / 1_000_000.0 + " ms");

        int[] arr2 = arr.clone();
        start = System.nanoTime();
        SortingAlgorithms.insertionSort(arr2);
        end = System.nanoTime();
        System.out.println("Insertion Sort time: " + (end - start) / 1_000_000.0 + " ms");

        int[] arr3 = arr.clone();
        start = System.nanoTime();
        SortingAlgorithms.mergeSort(arr3);
        end = System.nanoTime();
        System.out.println("Merge Sort time: " + (end - start) / 1_000_000.0 + " ms");
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size);
        }
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }
}

