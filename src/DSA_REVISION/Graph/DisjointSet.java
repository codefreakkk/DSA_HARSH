package DSA_REVISION.Graph;

import java.util.*;

public class DisjointSet {

    List<Integer> parent, size, rank;

    public DisjointSet(int nodes) {
        this.parent = new ArrayList<>();
        this.size = new ArrayList<>();
        this.rank = new ArrayList<>();

        for (int i = 0; i <= nodes; i++) {
            parent.add(i);
            size.add(1);
            rank.add(0);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }

        int ultimateParent = findParent(parent.get(node));
        parent.set(node, ultimateParent);
        return ultimateParent;
    }

    public void unionByRank(int u, int v) {
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if (parent_u == parent_v) {
            return;
        }

        if (rank.get(parent_v) < rank.get(parent_u)) {
            parent.set(parent_v, parent_u);
        }
        else if (rank.get(parent_u) < rank.get(parent_v)) {
            parent.set(parent_u, parent_v);
        }
        else {
            parent.set(parent_v, parent_u);
            int parent_u_rank = rank.get(parent_u);
            rank.set(parent_u, parent_u_rank + 1);
        }
    }

    public void unionBySize(int u, int v) {
        int parent_u = findParent(u);
        int parent_v = findParent(v);

        if (parent_u == parent_v) {
            return;
        }

        if (size.get(parent_v) < size.get(parent_u)) {
            parent.set(parent_v, parent_u);
            size.set(parent_u, size.get(parent_u) + size.get(parent_v));
        } else {
            parent.set(parent_u, parent_v);
            size.set(parent_v, size.get(parent_u) + size.get(parent_v));
        }
    }

    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet(7);
        ds.unionBySize(1, 2);
        ds.unionBySize(2, 3);
        ds.unionBySize(4, 5);
        ds.unionBySize(6, 7);
        ds.unionBySize(5, 6);
        if (ds.findParent(3) == ds.findParent(7))
            System.out.println("Same");
        else System.out.println("Not same");
        ds.unionBySize(3, 7);
        if (ds.findParent(3) == ds.findParent(7))
            System.out.println("Same");
        else System.out.println("Not same");
    }
}
