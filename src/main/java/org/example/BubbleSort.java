package org.example;

public class BubbleSort {

    public static void bubblesort(int[] arr, int N) {
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int N1 = 5;
        int[] arr1 = {4, 1, 3, 9, 7};
        bubblesort(arr1, N1);
        System.out.println("Sorted array:");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
        System.out.println();

        int N2 = 10;
        int[] arr2 = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        bubblesort(arr2, N2);
        System.out.println("Sorted array:");
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}
