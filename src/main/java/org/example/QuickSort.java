package org.example;

public class QuickSort {
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

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

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {4, 1, 3, 9, 7};
        int N1 = arr1.length;
        quickSort(arr1, 0, N1 - 1);
        System.out.println("Sorted array:");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        int[] arr2 = {2, 1, 6, 10, 4, 1, 3, 9, 7};
        int N2 = arr2.length;
        quickSort(arr2, 0, N2 - 1);
        System.out.println("Sorted array:");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}
