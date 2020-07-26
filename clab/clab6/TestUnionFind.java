import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

public class TestUnionFind {

    @Test
    public void TestParent() {
        UnionFind uf = new UnionFind(15);
        int actual = uf.parent(3);
        int expected = -1;
        Assert.assertEquals(expected, actual);

        int actual2 = uf.parent(5);
        int expected2 = -1;
        Assert.assertEquals(expected2, actual2);

        int actual3 = uf.parent(14);
        int expected3 = -1;
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void TestFind() {
        UnionFind uf = new UnionFind(15);
        int actual = uf.find(3);
        int expected = 3;
        Assert.assertEquals(expected, actual);

        int actual2 = uf.find(5);
        int expected2 = 5;
        Assert.assertEquals(expected2, actual2);

        int actual3 = uf.find(14);
        int expected3 = 14;
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void TestUnion() {
        UnionFind uf = new UnionFind(15);
        uf.union(2, 3);
        int parent2actual = uf.find(2);
        int parent2expected = 3;
        Assert.assertEquals(parent2expected, parent2actual);

        uf.union(4, 5);
        int parent4actual = uf.find(4);
        int parent4expected = 5;
        Assert.assertEquals(parent4expected, parent4actual);

        uf.union(2, 4);
        int parent3actual = uf.find(3);
        int parent3expected = 5;
        Assert.assertEquals(parent3expected, parent3actual);

        uf.union(6, 7);
        uf.union(8, 9);
        uf.union(6, 9);
        int parent6actual = uf.find(6);
        int parent6expected = 9;
        Assert.assertEquals(parent6expected, parent6actual);

        int parent7actual = uf.find(7);
        int parent7expected = 9;
        Assert.assertEquals(parent7expected, parent7actual);

        uf.union(2, 7);
        int size9actual = uf.sizeOf(9);
        int size9expected = 8;
        Assert.assertEquals(size9expected, size9actual);

    }

    @Test
    public void TestConnected() {
        UnionFind uf = new UnionFind(15);
        uf.union(2, 3);
        uf.union(4, 5);
        uf.union(2, 4);
        uf.union(6, 7);
        uf.union(8, 9);
        uf.union(6, 9);
        uf.union(2, 7);

        Assert.assertTrue(uf.connected(6, 2));
        Assert.assertFalse(uf.connected(6, 10));
        Assert.assertFalse(uf.connected(11, 10));

        int size2actual = uf.sizeOf(2);
        int size2expected = 8;
        Assert.assertEquals(size2expected, size2actual);
    }
}
