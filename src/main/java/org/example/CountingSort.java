package org.example;

public class CountingSort {

    public static String countSort(String arr) {
        int N = arr.length();
        int[] count = new int[26];
        char[] output = new char[N];

        for (int i = 0; i < N; i++) {
            count[arr.charAt(i) - 'a']++;
        }

        for (int i = 1; i < 26; i++) {
            count[i] += count[i - 1];
        }

        for (int i = N - 1; i >= 0; i--) {
            output[count[arr.charAt(i) - 'a'] - 1] = arr.charAt(i);
            count[arr.charAt(i) - 'a']--;
        }

        return new String(output);
    }

    public static void main(String[] args) {
        String S1 = "edsab";
        System.out.println("Sorted string: " + countSort(S1));

        String S2 = "geeksforgeeks";
        System.out.println("Sorted string: " + countSort(S2));
    }
}
