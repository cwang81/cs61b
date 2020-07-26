public class BubbleGrid {
    private int[][] grid;
    private int R;
    private int C;
    private UnionFind uf;
    private int[] results;
    private int count = 0;
    int[] dx = {0, -1, 0, 1};
    int[] dy = {-1, 0, 1, 0};

    /* Create new BubbleGrid with bubble/space locations specified by grid.
     * Grid is composed of only 1's and 0's, where 1's denote a bubble, and
     * 0's denote a space. */
    public BubbleGrid(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
    }

    /**
     * convert the axis of matrix into corresponding integer
     * @param row,col the row and col index of matrix
     * @return the converted index
     */
    private int axisConverter(int row, int col) {
        return row * C + col;
    }

    /**
     * union the neighbours of gird[r][c]
     */
    private void unionNeighbours(int r, int c, int[][] gridClone) {
        for (int i = 0; i < 4; i += 1) {
            int rNeighbour = r + dx[i];
            int cNeighbour = c + dy[i];
            if (rNeighbour >=0 && rNeighbour < R && cNeighbour >=0 && cNeighbour < C) {
                if (gridClone[rNeighbour][cNeighbour] == 1) {
                    uf.union(axisConverter(r, c), axisConverter(rNeighbour, cNeighbour));
                }
            }
        }
    }

    /**
     * union all linkables on the grid
     */
    private void unionGrid(int[][] gridClone) {
        for (int r = 0; r < R; r += 1) {
            for (int c = 0; c < C; c += 1) {
                if (gridClone[r][c] == 1) {
                    if (r == 0) {
                        uf.union(axisConverter(r, c), R * C);
                    } else {
                        unionNeighbours(r, c, gridClone);
                    }
                }
            }
        }
    }

    /* Returns an array whose i-th element is the number of bubbles that
     * fall after the i-th dart is thrown. Assume all elements of darts
     * are unique, valid locations in the grid. Must be non-destructive
     * and have no side-effects to grid. */
    public int[] popBubbles(int[][] darts) {
        // TODO
        results = new int[darts.length];
        /**
         * clone the original grid
         */
        int[][] gridClone = new int[R][C];
        for (int r = 0; r < R; r += 1) {
            gridClone[r] = grid[r].clone();
        }
        /**
         * set the darted bubbles to 0
         */
        for (int[] dart : darts) {
            gridClone[dart[0]][dart[1]] = 0;
        }


        uf = new UnionFind(R * C + 1);
        unionGrid(gridClone);
        int nextSize = uf.sizeOf(R * C);

        for (int k = darts.length - 1; k >= 0; k -= 1) {
            if (grid[darts[k][0]][darts[k][1]] == 0) {
                results[k] = 0;
            } else {
                gridClone[darts[k][0]][darts[k][1]] = 1;
                unionGrid(gridClone);
                int prevSize = uf.sizeOf(R * C);
                if (prevSize == nextSize) {
                    results[k] = 0;
                } else {
                    results[k] = prevSize - nextSize - 1;
                }
                nextSize = prevSize;
            }
        }

        return results;
    }
}
