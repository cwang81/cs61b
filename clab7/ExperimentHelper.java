/**
 * Created by hug.
 */
public class ExperimentHelper {

    /** Returns the internal path length for an optimum binary search tree of
     *  size N. Examples:
     *  N = 1, OIPL: 0
     *  N = 2, OIPL: 1
     *  N = 3, OIPL: 2
     *  N = 4, OIPL: 4
     *  N = 5, OIPL: 6
     *  N = 6, OIPL: 8
     *  N = 7, OIPL: 10
     *  N = 8, OIPL: 13
     */
    public static int optimalIPL(int N) {
        if (N <= 0) {
            throw new IllegalArgumentException();
        }

        int sum = 0;
        for(int i = 1; i <= N; i += 1) {
            int additive = (int) (Math.log(i)/Math.log(2));
            sum += additive;
        }
        return sum;
    }

    /** Returns the average depth for nodes in an optimal BST of
     *  size N.
     *  Examples:
     *  N = 1, OAD: 0
     *  N = 5, OAD: 1.2
     *  N = 8, OAD: 1.625
     * @return
     */
    public static double optimalAverageDepth(int N) {
        return (double) optimalIPL(N) / N;
    }

    public static void addInt(BST<Integer> bst) {
        int tmp = RandomGenerator.getRandomInt(10000);
        while (true) {
            if (!bst.contains(tmp)) {
                bst.add(tmp);
                break;
            } else {
                tmp = RandomGenerator.getRandomInt(10000);
            }
        }
    }
}
