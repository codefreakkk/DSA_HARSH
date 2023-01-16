package Graph;

import java.util.ArrayList;
import java.util.List;

public class DetectACycleInUndirectedGraphDisjointSet {
    class DisjointSet {
        List<Integer> size, parent;
        public DisjointSet(int V) {
            this.size = new ArrayList<>();
            this.parent = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findParent(int node) {
            if (parent.get(node) == node)
                return node;

            int parentNode = findParent(parent.get(node));
            parent.set(node, parentNode);
            return parentNode;
        }

        public void unionBySize(int u, int v) {
            int parent_u = findParent(u);
            int parent_v = findParent(v);
            if (parent_u == parent_v)
                return;

            if (size.get(parent_u) < size.get(parent_v)) {
                parent.set(parent_u, parent_v);
                size.set(parent_v, size.get(parent_u) + size.get(parent_v));
            }
            else {
                parent.set(parent_v, parent_u);
                size.set(parent_u, size.get(parent_u) + size.get(parent_v));
            }
        }
    }

    public int detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        DisjointSet ds = new DisjointSet(V);
        for (int i = 0; i < V; i++) {
            for (int adjNode : adj.get(i)) {
                if (ds.findParent(i) == ds.findParent(adjNode) && i < adjNode) {
                    return 1;
                }
                else
                    ds.unionBySize(i, adjNode);
            }
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
