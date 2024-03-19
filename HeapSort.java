import java.util.Scanner;
import java.util.Random;

public class HeapSort {
    public static void heapSort(double[] arr) {
        int n = arr.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Один за другим извлекаем элементы из кучи
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            double temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Процедура преобразует массив в кучу
    public static void heapify(double[] arr, int n, int i) {
        int largest = i; // Инициализация наибольшего элемента как корня
        int left = 2 * i + 1; // Левый потомок узла i
        int right = 2 * i + 2; // Правый потомок узла i

        // Если левый потомок больше корня
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Если правый потомок больше, чем самый большой элемент на данный момент
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Если наибольший элемент не корень
        if (largest != i) {
            double swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно вызываем heapify для уменьшенной кучи
            heapify(arr, n, largest);
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

        heapSort(arr);

        System.out.println("Отсортированный массив:");
        for (double num : arr) {
            System.out.print(num + " ");
        }

        scanner.close();
    }
}
