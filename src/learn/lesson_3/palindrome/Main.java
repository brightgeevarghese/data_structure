package learn.lesson_3.palindrome;

public class Main {
    public static void main(String[] args) {
        PalindromeFinder finder = new PalindromeFinder("malayalama");
        System.out.println(finder.isPalindrome());
    }
}
