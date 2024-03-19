import java.util.Scanner;
import java.util.Random;

public class BubbleSort {
    public static void bubbleSort(double[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    double temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
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

        bubbleSort(arr);

        System.out.println("Отсортированный массив:");
        for (double num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
