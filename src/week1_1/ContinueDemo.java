package week1_1;

public class ContinueDemo {
    public static void main(String[] args) {
        String[] a = {"cat", "mice", "bird", "dog", "horse", "ant"};

        for (String s: a) {

            for (int j = 0; j < 3; j++) {
                System.out.println(s);
                if (s.contains("dog"))
                    break;
            }
        }
    }
}
