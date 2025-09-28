package edu.yourname.assignment1;

import java.util.Random;

public class QuickSort {
    private static final int CUTOFF = 32;
    private static final Random rnd = new Random();

    public static void sort(int[] a, Metrics m) {
        if (a == null || a.length <= 1) return;
        quickSort(a, 0, a.length - 1, m);
    }

    private static void quickSort(int[] a, int lo, int hi, Metrics m) {
        while (lo < hi) {
            m.enter();
            try {
                if (hi - lo + 1 <= CUTOFF) {
                    InsertionSort.sort(a, lo, hi, m);
                    return;
                }
                int pivotIndex = partitionRandom(a, lo, hi, m);
                int leftSize = pivotIndex - lo;
                int rightSize = hi - pivotIndex;
                if (leftSize < rightSize) {
                    quickSort(a, lo, pivotIndex - 1, m);
                    lo = pivotIndex + 1;
                } else {
                    quickSort(a, pivotIndex + 1, hi, m);
                    hi = pivotIndex - 1;
                }
            } finally {
                m.exit();
            }
        }
    }

    private static int partitionRandom(int[] a, int lo, int hi, Metrics m) {
        int pivotIdx = lo + rnd.nextInt(hi - lo + 1);
        swap(a, pivotIdx, hi);
        int pivot = a[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            m.incComparisons();
            if (a[j] <= pivot) {
                i++;
                swap(a, i, j);
            }
        }
        swap(a, i + 1, hi);
        return i + 1;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
