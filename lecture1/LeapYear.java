package lecture1;

import java.util.Scanner;

public class LeapYear {
    /** this class inputs a year and outputs if it is a leap year. */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter test year: ");
            int year = scanner.nextInt();
            if (year < 0)
                break;
            if (isLeapYear(year))
                System.out.println(year + " is a leap year.");
            else
                System.out.println(year + " is not a leap year.");
        }
    }

    public static boolean isLeapYear(int year) {
        /** this method test if input is a leap year */
        if (year % 400 == 0)
            return true;
        else if (year % 4 == 0) {
            if (year % 100 == 0)
                return false;
            else
                return true;
        }
        else
            return false;
    }
}
