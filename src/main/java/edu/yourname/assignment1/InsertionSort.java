package edu.yourname.assignment1;

public class InsertionSort {
    public static void sort(int[] a, int lo, int hi, Metrics m) {
        for (int i = lo + 1; i <= hi; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= lo) {
                m.incComparisons();
                if (a[j] > key) {
                    a[j + 1] = a[j];
                    j--;
                } else break;
            }
            a[j + 1] = key;
        }
    }
}
