package lecture2;

public class ArgsSum {
    public static void main(String[] args) {
        int len = args.length;
        int sum = 0;
        int i = 0;
        while (i < len) {
            sum += Integer.parseInt(args[i]);
            i ++;
        }
        System.out.println(sum);
    }
}
