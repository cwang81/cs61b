package hw2;

public class UnionFind {
    private int[] uf;

    public UnionFind(int n) {
        uf = new int[n];
        for (int i = 0; i < uf.length; i += 1) {
            uf[i] = -1;
        }
    }

    public void validate(int v1) {
        if (v1 < 0 || v1 >= uf.length) {
            throw new IllegalArgumentException();
        }
    }

    public int sizeOf(int v1) {
        return -parent(find(v1));
    }

    public int parent(int v1) {
        return uf[v1];
    }

    public boolean connected(int v1, int v2) {
        if (parent(v1) == -1 || parent(v2) == -1) {
            return false;
        }
        return find(v1) == find(v2);
    }

    public void union(int v1, int v2) {
        if (connected(v1, v2)) {
            return;
        } else {
            if (sizeOf(v1) <= sizeOf(v2)) {
                uf[find(v2)] -= sizeOf(v1);
                uf[find(v1)] = find(v2);
            } else {
                uf[find(v1)] -= sizeOf(v2);
                uf[find(v2)] = find(v1);
            }
        }
    }

    public int find(int v1) {
        if (parent(v1) > 0) {
            uf[v1] = find(parent(v1));
            return uf[v1];
        } else {
            return v1;
        }
    }

}
