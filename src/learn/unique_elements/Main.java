package learn.unique_elements;

public class Main {
    public static boolean areUnique(int[] x) {
        for(int i = 0; i < x.length; i++) {
            for(int j = i + 1; j < x.length; j++) {
                if (i != j && x[i] == x[j])
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] x = {1, 2, 3, 4, 5};
        System.out.println(areUnique(x));
    }
}
