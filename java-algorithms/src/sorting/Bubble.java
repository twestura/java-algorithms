package sorting;

import static sorting.Util.swap;

public class Bubble {
    public static void bubbleSort(int[] a) {
        for (int j = a.length - 1; j > 0; --j)
            for (int i = 0; i < j; ++i)
                if (a[i] > a[i + 1]) swap(a, i, i + 1);
    }

    public static void bubbleSort(int[] a, int left, int right) {
        for (int j = right - 1; j > left; --j)
            for (int i = left; i < j; ++i)
                if (a[i] > a[i + 1]) swap(a, i, i + 1);
    }
}

// What is the sequence diagram?
// Can I stop once it's in place? Do I have to loop all the way to the end?
// Can I move a segment like insertion sort without all of the swaps?
// Can I break a loop early?
// Can I skip iterations?
