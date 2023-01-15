package Graph;

import java.util.*;

public class DisjointSet {
    List<Integer> rank, parent;
    public DisjointSet(int n) {
        this.rank = new ArrayList<>();
        this.parent = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node))
            return node;

        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    public void unionByRank(int u, int v) {
        int parent_u = findParent(u);
        int parent_v = findParent(v);
        if (rank.get(parent_u) < rank.get(parent_v)) {
            parent.set(parent_u, parent_v);
        }
        else if (rank.get(parent_v) < rank.get(parent_u)) {
            parent.set(parent_v, parent_u);
        }
        else {
            parent.set(parent_v, parent_u);
            int rank_u = rank.get(u);
            rank.set(parent_u, rank_u + 1);
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);
        if (ds.findParent(3) == ds.findParent(7))
            System.out.println("Same");
        else System.out.println("Not same");
        ds.unionByRank(3, 7);
        if (ds.findParent(3) == ds.findParent(7))
            System.out.println("Same");
        else System.out.println("Not same");
    }
}
