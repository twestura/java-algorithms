package sorting;

import static sorting.Util.swap;

public class Heap {
    public static void bubbleDown(int[] a, int i, int n) {
        var half = n >>> 1;
        while (i < half) {
            var j = (i << 1) + 2;
            if (j == n || a[j - 1] > a[j]) --j;
            if (a[i] >= a[j]) return;
            swap(a, i, j);
            i = j;
        }
    }

    public static void heapSort(int[] a) {
        var n = a.length;
        for (var i = (n >>> 1) - 1; i >= 0; --i) bubbleDown(a, i, n);
        for (var i = a.length - 1; i > 0; --i) {
            swap(a, 0, i);
            bubbleDown(a, 0, i);
        }
    }

    public static void bubbleDown(int[] a, int i, int left, int right) {
        var half = (left + right) >>> 1;
        while (i < half) {
            var j = left + ((i - left) << 1) + 2;
            if (j == right || a[j - 1] > a[j]) --j;
            if (a[i] >= a[j]) return;
            swap(a, i, j);
            i = j;
        }
    }

    public static void heapSort(int[] a, int left, int right) {
        for (var i = ((left + right) >>> 1) - 1; i >= left; --i)
            bubbleDown(a, i, left, right);
        for (var i = right - 1; i > left; --i) {
            swap(a, left, i);
            bubbleDown(a, left, left, i);
        }
    }
}
