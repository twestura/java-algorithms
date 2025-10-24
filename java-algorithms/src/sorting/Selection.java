package sorting;

import static sorting.Util.swap;

/** An implementation of selection sort. */
public class Selection {

    /**
     * Sorts {@code a} in place. The sort may be unstable.
     * @param a the array to sort.
     */
    public static void selectionSort(int[] a) {
        for (var i = 0; i < a.length - 1; ++i) swap(a, i, argmin(a, i));
    }

    /**
     * Returns an index of a minimum value of {@code a[i..]}.
     * Requires {@code 0 <= i < a.length}.
     *
     * @param a the array from which to get the minimum index
     * @param i the index at which to start searching
     * @return an index of a minimum value of {@code a[i..]}
     */
    public static int argmin(int[] a, int i) {
        var argmin = i++;
        for (; i < a.length; ++i)
            if (a[i] < a[argmin]) argmin = i;
        return argmin;
    }

    /**
     * Sorts {@code a} in place. The sort may be unstable.
     * Requires {@code 0 <= left <= right <= a.length}.
     *
     * @param a the array to sort
     * @param left inclusive left endpoint
     * @param right exclusive right endpoint
     */
    public static void selectionSort(int[] a, int left, int right) {
        for (var i = left; i < right - 1; ++i) swap(a, i, argmin(a, i, right));
    }

    /**
     * Returns an index of a minimum element of {@code a[i..right]}.
     * Requires {@code 0 <= i < right <= a.length}.
     *
     * @param a the array to search
     * @param i inclusive left search index
     * @param right exclusive right search index
     * @return an index of a minimum element of {@code a[i..right]}
     */
    public static int argmin(int[] a, int i, int right) {
        var argmin = i++;
        for (; i < right; ++i)
            if (a[i] < a[argmin]) argmin = i;
        return argmin;
    }

    /**
     * Stably sorts {@code a} in-place.
     * @param a the array to sort
     */
    public static void selectionSortStable(int[] a) {
        for (var i = 0; i < a.length - 1; ++i) {
            var j = argmin(a, i);
            var min = a[j];
            System.arraycopy(a, i, a, i + 1, j - i);
            a[i] = min;
        }
    }
}
