package week1_1;

public class BreakContinue {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, -3, 4, 5, 4};
        int[] b = new int[]{1, -1, -1, 10, 5, -1};
        windowPosSum(a, 3);
        windowPosSum(b, 2);
        System.out.println(java.util.Arrays.toString(a));
        System.out.println(java.util.Arrays.toString(b));
    }

    public static void windowPosSum (int[] a, int n) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0)
                continue;
            for (int j = 1; j <= n; j++) {
                if (i + j < a.length)
                    a[i] += a[i + j];
                else
                    break;
            }
        }
    }
}
