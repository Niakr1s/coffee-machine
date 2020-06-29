package machine.util;

public class Math {
    public static <T extends Comparable<T>> T min(T first, T... arr) {
        T res = first;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(res) < 0) {
                res = arr[i];
            }
        }
        return res;
    }

    public static <T extends Comparable<T>> T max(T first, T... arr) {
        T res = first;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].compareTo(res) > 0) {
                res = arr[i];
            }
        }
        return res;
    }

    /**
     * Safe implementation of divide operation.
     * @param a
     * @param b
     * @return Integer.MAX_VALUE if b is zero.
     */
    public static int divideOrMax(int a, int b) {
        if (b == 0) {
            return Integer.MAX_VALUE;
        }
        return a / b;
    }


    /**
     * Safe implementation of divide operation.
     * @param a
     * @param b
     * @return Integer.MIN_VALUE if b is zero.
     */
    public static int divideOrMin(int a, int b) {
        if (b == 0) {
            return Integer.MIN_VALUE;
        }
        return a / b;
    }
}
