package learn.lesson_5.x_power_n;

public class Main {
    static int xPowerN(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * xPowerN(x, n - 1);
        }
    }
    public static void main(String[] args) {
        System.out.println( xPowerN(2, 3));
    }
}
