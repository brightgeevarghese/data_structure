package learn.lesson_5.gcd;

public class Main {
    static int gcd(int m, int n) {
        if (m % n == 0) { //For m > n
            return n;
        } else if (n > m) {//For n > m
            return gcd(n, m);
        } else {
            return gcd(n, m % n);
        }
    }
    public static void main(String[] args) {
        System.out.println(gcd(12, 18));
        System.out.println(gcd(18, 12));
    }
}
