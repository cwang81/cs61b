package week1_1;

public class MaxInArray {
    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 22, 1, -7, 2, 0, 33, 1, 2, 7};
        System.out.println(max(numbers));
    }

    public static int max(int[] m) {
        int i = 0, tmp = m[m.length - 1];
        while (i < m.length) {
            if (m[i] > tmp) {
                tmp = m[i];
            }
            i++;
        }
        return tmp;
    }
}
