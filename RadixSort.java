import java.util.Scanner;
import java.util.Random;

public class RadixSort {

    // Функция для сортировки массива с помощью сортировки поразрядной
    public static void radixSort(double[] arr) {
        // Находим максимальное число в массиве для определения количества разрядов
        double max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Преобразуем максимальное число в целое для определения количества разрядов
        int maxInt = (int) max;

        // Вызываем сортировку по каждому разряду
        for (int exp = 1; maxInt / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Функция для сортировки массива по определенному разряду
    public static void countingSort(double[] arr, int exp) {
        int n = arr.length;
        double[] output = new double[n];
        int[] count = new int[10]; // Для хранения количества элементов по каждому разряду

        // Подсчитываем количество элементов на каждом разряде
        for (int i = 0; i < n; i++) {
            int digit = (int) (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Изменяем count[i] так, чтобы он содержал фактическую позицию этого разряда в output
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Строим output массив
        for (int i = n - 1; i >= 0; i--) {
            int digit = (int) (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Копируем отсортированный массив обратно в arr[]
        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
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

        radixSort(arr);

        System.out.println("Отсортированный массив:");
        for (double num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
