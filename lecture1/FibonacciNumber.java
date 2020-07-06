package lecture1;

import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number (>0): ");
            int n = scanner.nextInt();
            if (n < 1)
                break;
            int answer = fib(n, 1, 0, 1);
            System.out.println("The " + n + "th Fibonacci number is: " + answer);
        }
    }

    public static int fib(int n, int k, int f0, int f1) {
        if (n == k)
            return f0;
        else
            return fib(n, k + 1, f1, f0 + f1);
    }
}
