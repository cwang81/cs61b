package lecture1;

public class HelloNumbers {
    public static void main(String[] args) {
        /*
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
         }
         */

        int i = 0, sum = 0;
        while (i < 10) {
            sum += i;
            System.out.print(sum + " ");
            i++;
        }
        System.out.println("");
    }
}
