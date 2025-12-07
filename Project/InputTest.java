import java.util.Scanner;

public class InputTest {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter numbers separated by space: ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        int[] numbers = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            numbers[i] = Integer.parseInt(parts[i]);
        }

        System.out.print("Choose algorithm (quick/bubble): ");
        String algo = sc.nextLine().trim().toLowerCase();

        if (algo.equals("quick")) {
            quickSort(numbers, 0, numbers.length - 1);
        } else if (algo.equals("bubble")) {
            bubbleSort(numbers);
        } else {
            System.out.println("Invalid algorithm choice!");
            sc.close();
            return;
        }

        System.out.print("Sorted: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        sc.close();
    }
}
