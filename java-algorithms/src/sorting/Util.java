package sorting;

/** Utility functions for implementing sorting algorithms. */
public class Util {

    /**
     * Swaps {@code a[i]} and {@code a[j]}.
     * Requires {@code 0 <= i, j < a.length}.
     */
    public static void swap(int[] a, int i, int j) {
        var temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * Returns the floor of the base 2 logarithm of {@code n}.
     * If {@code n == 0}, returns {@code 0}.
     * Requires {@code n >= 0}.
     * @param n the integer of which the logarithm is taken
     * @return {@code floor(log2(n))} for {@code n > 0},
     *         {@code 0} for {@code n == 0}
     */
    public static int ilog2(int n) {
        return 31 - Integer.numberOfLeadingZeros(n | 1);
    }
}
