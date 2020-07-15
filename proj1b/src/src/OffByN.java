
public class OffByN implements CharacterComparator {

    @Override
    public boolean equalChars(char x, char y){
        if (!(x >= 65 && x <= 122 && y >= 65 & y <= 122)) {
            System.out.println("Please enter a valid word!");
            return false;
        }
        boolean res = Math.abs(x - y) == N;
        return res;
    }

    private int N;

    public OffByN(int N) {
        this.N = N;
    }
}
