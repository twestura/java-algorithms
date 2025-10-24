package sorting;

import static sorting.Insertion.insertionSort;

public class Merge {
    /** Cutoff at which to use insertion sort. */
    public static int INSERTION_CUTOFF = 16;

    /**
     * Stably sorts {@code a} in-place.
     * @param a the array to sort.
     */
    public static void mergeSort(int[] a) {
        mergeSort(a, 0, a.length);
    }

    /**
     * Stably sorts {@code a[left..right]} in-place.
     * Requires {@code 0 <= left <= right <= a}.
     *
     * @param a the array to sort
     * @param left inclusive left endpoint
     * @param right exclusive right endpoint
     */
    public static void mergeSort(int[] a, int left, int right) {
        mergeSort(a, left, right, new int[a.length >>> 1]);
    }

    /**
     * Stably sorts {@code a[left..right]} in-place. May mutate {@code t}.
     * Requires {@code 0 <= left <= right <= a}
     * and {@code t.length >= (right - left) >>> 1}.
     *
     * @param a the array to sort
     * @param left inclusive left endpoint
     * @param right exclusive right endpoint
     * @param t temporary work array
     */
    private static void mergeSort(int[] a, int left, int right, int[] t) {
        if (right - left < INSERTION_CUTOFF) insertionSort(a, left, right);
        else {
            var mid = (left + right) >>> 1;
            mergeSort(a, left, mid, t);
            mergeSort(a, mid, right, t);
            merge(a, left, mid, right, t);
        }
    }

    /**
     * Places {@code a[left..right]} in sorted order.
     * Requires {@code 0 <= left <= mid <= right <= a.length},
     * {@code a[left..mid]} and {@code a[mid..right]} are sorted,
     * and {@code t.length >= mid - left}.
     *
     * @param a the array to sort
     * @param left inclusive left endpoint of the first sorted half
     * @param mid splits the two sorted halves as the exclusive end of the
     *            first hals and inclusive start of the second half
     * @param right exclusive right endpoint of the second sorted half
     * @param t work array large enough to store {@code a[left..mid]}
     */
    public static void merge(int[] a, int left, int mid, int right, int[] t) {
        var leftLen = mid - left;
        System.arraycopy(a, left, t, 0, leftLen);
        int i = 0, j = mid, k = left;
        while (i < leftLen && j < right) a[k++] = a[j] > t[i] ? t[i++] : a[j++];
        System.arraycopy(t, i, a, k, leftLen - i);
    }
}
