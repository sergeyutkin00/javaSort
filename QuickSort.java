import java.util.Scanner;
import java.util.Random;

public class QuickSort {

    // Функция для сортировки массива с использованием быстрой сортировки
    public static void quickSort(double[] arr, int low, int high) {
        if (low < high) {
            // Разбиение массива и получение индекса опорного элемента
            int pi = partition(arr, low, high);

            // Рекурсивно сортируем элементы перед опорным и после опорного
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // Функция для разделения массива и возврата индекса опорного элемента
    public static int partition(double[] arr, int low, int high) {
        double pivot = arr[high];
        int i = (low - 1); // Индекс меньшего элемента

        for (int j = low; j < high; j++) {
            // Если текущий элемент меньше или равен опорному
            if (arr[j] <= pivot) {
                i++;

                // Поменять местами arr[i] и arr[j]
                double temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Поменять местами arr[i+1] и arr[high] (или опорным элементом)
        double temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        double[] arr = new double[size];

        Random random = new Random();
        System.out.println("Заполняем массив случайными числами:");
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextDouble() * 100;
        }

        System.out.println("Исходный массив:");
        for (double num : arr) {
            System.out.print(num + " ");
        }

        System.out.println();

        quickSort(arr, 0, size - 1);

        System.out.println("Отсортированный массив:");
        for (double num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
