package week1_1;

import java.util.Scanner;

public class FibonacciNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number (>0): ");
            int n = scanner.nextInt();
            if (n < 1)
                break;
            int answer = fib(n, 0,0,1);
            System.out.println("The " + n + "th Fibonacci number is: " + answer);
        }
    }

    public static int fib(int n, int k, int f0, int f1) {
        if (n != 0)
            for (int i = 0; i < n - 1; i++) {
                k = f0 + f1;
                f1 = f0;
                f0 = k;
            }
        return k;
    }
}
