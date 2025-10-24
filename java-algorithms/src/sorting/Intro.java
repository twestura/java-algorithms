package sorting;

import static sorting.Heap.heapSort;
import static sorting.Insertion.insertionSort;
import static sorting.Quick.med3;
import static sorting.Quick.partition;
import static sorting.Util.swap;

public class Intro {
    public static int INSERTION_CUTOFF = 16;

    public static void introSort(int[] a) {
        introSort(a, 0, a.length);
    }

    public static void introSort(int[] a, int left, int right) {
        introSortLoop(a, left, right, ilog2(right - left) << 1);
        insertionSort(a, left, right);
    }

    public static void introSortLoop(int[] a, int left, int right, int depthLimit) {
        while (right - left > INSERTION_CUTOFF) {
            if (depthLimit == 0) {
                heapSort(a, left, right);
                return;
            }
            swap(a, left, med3(a, left, (left + right) >>> 1, right - 1));
            var p = partition(a, left, right);
            introSortLoop(a, left, p, --depthLimit);
            left = p;
        }
    }

    public static int ilog2(int n) {
        return 31 - Integer.numberOfLeadingZeros(n | 1);
    }
}
