package week1_1;

public class TriangleDrawing {
    public static void main(String[] args) {
        drawTriangle(7);
    }

    public static void drawTriangle (int N) {
        int tmp = N;
        while (N > 0) {
            int j = 0;
            while (N + j <= tmp) {
                System.out.print("*");
                j++;
            }
            System.out.println();
            N--;
        }
    }
}
