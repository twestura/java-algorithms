package sorting;

import static sorting.Insertion.insertionSort;
import static sorting.Util.swap;

public class Quick {
    /** Cutoff at which to use insertion sort. */
    public static int INSERTION_CUTOFF = 16;

    /**
     * Sorts {@code a} in place. The sort may be unstable.
     * @param a the array to sort
     */
    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length);
    }

    /**
     * Sorts {@code a[left..right]} in place. The sort may be unstable.
     * Requires {@code 0 <= left <= right <= a.length}.
     *
     * @param a the array to sort
     * @param left inclusive left endpoint
     * @param right exclusive right endpoint
     */
    public static void quickSort(int[] a, int left, int right) {
        while (right - left > INSERTION_CUTOFF) {
            swap(a, left, med3(a, left, (left + right) >>> 1, right - 1));
            var p = partition(a, left, right);
            if (p - left < right - p) {
                quickSort(a, left, p);
                left = p;
            } else {
                quickSort(a, p, right);
                right = p;
            }
        }
        insertionSort(a, left, right);
    }

    /**
     * Returns the index of the median value of {@code a[i]}, {@code a[j]},
     * and {@code a[k]}. Requires {@code 0 <= i, j, k < a.length}.
     *
     * @param a the array of values
     * @param i the first index
     * @param j the second index
     * @param k the third index
     * @return the index of the median value
     */
    public static int med3(int[] a, int i, int j, int k) {
        int x = a[i], y = a[j], z = a[k];
        var xy = x > y;
        return xy ^ (x > z) ? i : xy ^ (z > y) ? j : k;
    }

    /**
     * Partitions {@code a[left..right]} and returns the partition index.
     * <p>
     * Requires {@code 0 <= left < right <= a.length} and that there exists
     * a value in {@code a[(left + 1)..right]} that is greater than or equal
     * to {@code a[left]}. Note this condition is satisfied
     * if {@code right - left >= 3} and {@code a[left]} has been swapped with
     * the median of the first, middle, and last elements of {@code a[left..right]}.
     *
     * @param a the array to partition
     * @param left inclusive left endpoint used as the pivot
     * @param right exclusive right endpoint
     * @return an index {@code p} such that {@code a[left..p] <= a[p..right]}
     */
    public static int partition(int[] a, int left, int right) {
        var pivot = a[left];
        while (true) {
            while (a[++left] > pivot);
            while (a[--right] > pivot);
            if (left >= right) return right + 1;
            swap(a, left, right);
        }
    }

//    public static int partition(int[] a, int left, int right) {
//        var pivot = a[left];
//        while (true) {
//            while (a[--right] > pivot);
//            if (left >= right) return right + 1;
//            swap(a, left, right);
//            while (a[++left] > pivot);
//        }
//    }
}
