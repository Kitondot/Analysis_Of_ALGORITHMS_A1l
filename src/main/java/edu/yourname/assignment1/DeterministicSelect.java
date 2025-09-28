package edu.yourname.assignment1;

import java.util.Arrays;

public class DeterministicSelect {
    public static int select(int[] a, int k, Metrics m) {
        if (k < 0 || k >= a.length) throw new IllegalArgumentException("k out of range");
        return select(a, 0, a.length - 1, k, m);
    }

    private static int select(int[] a, int lo, int hi, int k, Metrics m) {
        while (true) {
            if (lo == hi) return a[lo];
            int pivot = medianOfMedians(a, lo, hi, m);
            int pivotIndex = partition(a, lo, hi, pivot, m);
            if (k == pivotIndex) return a[k];
            else if (k < pivotIndex) hi = pivotIndex - 1;
            else lo = pivotIndex + 1;
        }
    }

    private static int medianOfMedians(int[] a, int lo, int hi, Metrics m) {
        int n = hi - lo + 1;
        if (n < 5) {
            Arrays.sort(a, lo, hi + 1);
            return a[lo + n / 2];
        }
        int numMedians = 0;
        for (int i = lo; i <= hi; i += 5) {
            int subHi = Math.min(i + 4, hi);
            Arrays.sort(a, i, subHi + 1);
            int median = a[i + (subHi - i) / 2];
            a[lo + numMedians] = median;
            numMedians++;
        }
        return medianOfMedians(a, lo, lo + numMedians - 1, m);
    }

    private static int partition(int[] a, int lo, int hi, int pivot, Metrics m) {
        int i = lo, j = hi;
        while (i <= j) {
            while (i <= j && a[i] < pivot) { m.incComparisons(); i++; }
            while (i <= j && a[j] > pivot) { m.incComparisons(); j--; }
            if (i <= j) { int t=a[i];a[i]=a[j];a[j]=t; i++; j--; }
        }
        return i - 1;
    }
}
