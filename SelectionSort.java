import java.util.Scanner;
import java.util.Random;

public class SelectionSort {
    public static void selectionSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                double temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        double[] arr = new double[size];

        Random random = new Random();

        for (int i = 0; i < size; i++) {
            arr[i] = random.nextDouble() * 100;
        }

        System.out.println("Исходный массив:");
        for (double num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();

        selectionSort(arr);

        System.out.println("Отсортированный массив:");
        for (double num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
