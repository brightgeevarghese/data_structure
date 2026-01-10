package learn.lesson_5.binary_search;

import java.util.Arrays;

public class Main {
    static <T> int binarySearch(T[] items, Comparable<T> target, int first, int last) {
//    static int binarySearch(Object[] items, Comparable target, int first, int last) {
        if (first > last) {
            return -1;
        } else {
            int mid = (first + last) / 2;
            int compareResult = target.compareTo(items[mid]);
            if (compareResult == 0) {
                return mid;//Base case for a successful result
            } else if (compareResult < 0) {
                return binarySearch(items, target, first, mid - 1);
            } else {
                return binarySearch(items, target, mid + 1, last);
            }
        }
    }
    public static void main(String[] args) {
        Integer []numbers = {10, 20, 30, 40, 50};
        System.out.println(binarySearch(numbers, 30, 0, numbers.length - 1));
        System.out.println(Arrays.binarySearch(numbers, 30.2));
    }
}
