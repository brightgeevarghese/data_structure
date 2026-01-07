package learn.binary_search;

public class Main {
    static int binarySearch(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int []scores = {77, 88, 66, 78, 99, 56};
        System.out.println(binarySearch(scores, 78));//3
        System.out.println(binarySearch(scores, 100));//-1
    }
}
