package sorting;

/** An implementation of insertion sort. */
public class Insertion {
    /**
     * Stably sorts {@code a} in-place.
     * @param a the array to sort
     */
    public static void insertionSort(int[] a) {
        for (var i = 1; i < a.length; ++i) insert(a, i);
    }

    /**
     * Inserts {@code a[i]} into sorted position in {@code a[..=i]}.
     * Requires {@code 0 <= i < a.length} and {@code a[..i]} is sorted.
     *
     * @param a the array in which to insert the value
     * @param i the index of the value to insert
     */
    public static void insert(int[] a, int i) {
        var key = a[i];
        for (; i > 0 && a[i - 1] > key; --i) a[i] = a[i - 1];
        a[i] = key;
    }

    /**
     * Stably sorts {@code a[left..right]} in-place.
     * Requires {@code 0 <= left <= right <= a.length}.
     *
     * @param a the array to sort
     * @param left inclusive left endpoint
     * @param right exclusive right endpoint
     */
    public static void insertionSort(int[] a, int left, int right) {
        for (var i = left + 1; i < right; ++i) insert(a, left, i);
    }

    /**
     * Inserts {@code a[i]} into sorted position in {@code a[left..=i]}.
     * Requires {@code 0 <= left <= i < a.length}
     * and {@code a[left..i]} is sorted.
     *
     * @param a the array in which to insert the value
     * @param i the index of the value to insert
     * @param left inclusive start index of the slice in which
     *             to insert {@code a[i]}
     */
    public static void insert(int[] a, int left, int i) {
        var key = a[i];
        for (; i > left && a[i - 1] > key; --i) a[i] = a[i - 1];
        a[i] = key;
    }
}
