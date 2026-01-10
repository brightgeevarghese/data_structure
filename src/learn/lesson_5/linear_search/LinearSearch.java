package learn.lesson_5.linear_search;

public class LinearSearch {

    /***
     * Linear search
     * @param items The array to be searched
     * @param target The target to be found
     * @param posFirst The first position to be searched
     * @return The position of the target if found; otherwise, return -1
     */
    static int linearSearch(
            Object[] items,
            Object target,
            int posFirst
    ) {
        if (posFirst == items.length) {
            return -1;
        } else if (items[posFirst].equals(target)) {
            return posFirst;
        } else {
            return linearSearch(items, target, posFirst + 1);
        }
    }
    public static void main(String[] args) {
        String[] scores = {"77", "88", "66", "78", "99", "56"};
        System.out.println(linearSearch(scores, "78", 0));
    }
}
