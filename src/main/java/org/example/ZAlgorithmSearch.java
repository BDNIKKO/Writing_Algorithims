package org.example;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithmSearch {

    private static int[] calculateZ(String concat) {
        int n = concat.length();
        int[] Z = new int[n];  // Z array to store the length of the longest substring starting at each position that matches the prefix
        int L = 0, R = 0;  // L and R are the bounds of the current "Z-box"

        for (int i = 1; i < n; i++) {
            if (i > R) {
                // We are outside the current Z-box, so we reset L and R
                L = R = i;
                while (R < n && concat.charAt(R) == concat.charAt(R - L)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else {
                // We are inside the current Z-box
                int K = i - L;
                if (Z[K] < R - i + 1) {
                    Z[i] = Z[K];  // Reuse the Z value from the prefix
                } else {
                    // Need to calculate Z[i] from scratch beyond the current Z-box
                    L = i;
                    while (R < n && concat.charAt(R) == concat.charAt(R - L)) {
                        R++;
                    }
                    Z[i] = R - L;
                    R--;
                }
            }
        }
        return Z;
    }

    public static List<Integer> search(String S, String pat) {
        // concat is used to combine the pattern, a unique delimiter, and the text.
        // This allows us to use the Z-algorithm to find matches of the pattern in the text.
        String concat = pat + "$" + S;

        // Length of the pattern
        int l = pat.length();

        // Compute the Z array for the concatenated string
        int[] Z = calculateZ(concat);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Z.length; i++) {
            // We check if the Z value equals the length of the pattern
            // and ensure we are looking at the text part of the concatenation
            if (Z[i] == l && i > l) {
                // Convert from 0-based to 1-based index for the text part
                result.add(i - l);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String S1 = "batmanandrobinarebat";
        String pat1 = "bat";
        List<Integer> result1 = search(S1, pat1);
        if (result1.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int index : result1) {
                System.out.print(index + " ");
            }
        }
        System.out.println();

        String S2 = "abesdu";
        String pat2 = "edu";
        List<Integer> result2 = search(S2, pat2);
        if (result2.isEmpty()) {
            System.out.println("-1");
        } else {
            for (int index : result2) {
                System.out.print(index + " ");
            }
        }
    }
}
