package org.example;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithmSearch {
    private static int[] calculateZ(String concat) {
        int n = concat.length();
        int[] Z = new int[n];
        int L = 0, R = 0;

        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && concat.charAt(R) == concat.charAt(R - L)) {
                    R++;
                }
                Z[i] = R - L;
                R--;
            } else {
                int K = i - L;
                if (Z[K] < R - i + 1) {
                    Z[i] = Z[K];
                } else {
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
        String concat = pat + "$" + S;
        int l = pat.length();
        int[] Z = calculateZ(concat);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Z.length; i++) {
            if (Z[i] == l && i > l) {
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