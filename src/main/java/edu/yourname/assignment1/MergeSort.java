package edu.yourname.assignment1;

public class MergeSort {
    private static final int CUTOFF = 32;

    public static void sort(int[] a, Metrics m) {
        if (a == null || a.length <= 1) return;
        int[] buf = new int[a.length];
        m.incAllocations(a.length);
        sort(a, buf, 0, a.length - 1, m);
    }

    private static void sort(int[] a, int[] buf, int lo, int hi, Metrics m) {
        m.enter();
        try {
            if (hi - lo <= CUTOFF) {
                InsertionSort.sort(a, lo, hi, m);
                return;
            }
            int mid = (lo + hi) >>> 1;
            sort(a, buf, lo, mid, m);
            sort(a, buf, mid + 1, hi, m);
            merge(a, buf, lo, mid, hi, m);
        } finally {
            m.exit();
        }
    }

    private static void merge(int[] a, int[] buf, int lo, int mid, int hi, Metrics m) {
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            m.incComparisons();
            if (a[i] <= a[j]) buf[k++] = a[i++];
            else buf[k++] = a[j++];
        }
        while (i <= mid) buf[k++] = a[i++];
        while (j <= hi) buf[k++] = a[j++];
        for (k = lo; k <= hi; k++) a[k] = buf[k];
    }
}
