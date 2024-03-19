import java.util.Scanner;
import java.util.Random;

public class MergeSort {
    public static void mergeSort(double[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(double[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        double[] L = new double[n1];
        double[] R = new double[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        double[] arr = new double[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextDouble() * 100; // Генерируем случайное число от 0 до 100
        }

        System.out.println("Исходный массив:");
        for (double num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("Отсортированный массив:");
        for (double num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
