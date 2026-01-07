package learn.linear_search;

import java.util.concurrent.TimeUnit;

public class Main {
    static int search(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] scores = {77, 88, 66, 78, 99, 56};
        if (search(scores, 78) != -1) {
            System.out.println("Found");
        }
        long systemTimeStart = System.nanoTime();
        System.out.println(search(scores, 78));
        long systemTimeEnd = System.nanoTime();
        System.out.println("Time taken: " + (systemTimeEnd - systemTimeStart));
        long elapsedTime = systemTimeEnd - systemTimeStart;
        System.out.println("Time taken: " + TimeUnit.NANOSECONDS.toHours(elapsedTime) + " hours " + TimeUnit.NANOSECONDS.toMinutes(elapsedTime) + " minutes " + TimeUnit.NANOSECONDS.toSeconds(elapsedTime) + " seconds " + TimeUnit.NANOSECONDS.toMillis(elapsedTime) + " milliseconds " + TimeUnit.NANOSECONDS.toMicros(elapsedTime) + " microseconds ");
        System.out.printf(
                "Time taken: %d hours %d minutes %d seconds %d milliseconds %d microseconds%n",
                TimeUnit.NANOSECONDS.toHours(elapsedTime),
                TimeUnit.NANOSECONDS.toMinutes(elapsedTime) % 60,
                TimeUnit.NANOSECONDS.toSeconds(elapsedTime) % 60,
                TimeUnit.NANOSECONDS.toMillis(elapsedTime) % 1000,
                TimeUnit.NANOSECONDS.toMicros(elapsedTime) % 1000
        );
    }
}
