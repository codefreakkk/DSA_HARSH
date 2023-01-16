package Graph;

import java.util.*;

public class AccountsMergeDSU {
    class DisjointSet {
        List<Integer> size, parent;
        public DisjointSet(int V) {
            this.size = new ArrayList<>();
            this.parent = new ArrayList<>();
            for (int i = 0; i <= V; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        public int findParent(int node) {
            if (node == parent.get(node))
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

            if (size.get(parent_v) < size.get(parent_u)) {
                parent.set(parent_v, parent_u);
                size.set(parent_u, size.get(parent_v) + size.get(parent_u));
            }
            else {
                parent.set(parent_u, parent_v);
                size.set(parent_v, size.get(parent_v) + size.get(parent_u));
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int v = accounts.size();
        HashMap<String, Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(v);

        // find ultimate parents of all accounts
        for (int i = 0; i < v; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String element = accounts.get(i).get(j);
                if (!map.containsKey(element))
                    map.put(element, i);
                else
                    ds.unionBySize(i, map.get(element));
            }
        }

        List<String>[] list = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            list[i] = new ArrayList<>();
        }

        // store data in new list[] according to their parents
        for (Map.Entry<String, Integer> mp : map.entrySet()) {
            String mail = mp.getKey();
            int index = ds.findParent(mp.getValue());
            list[index].add(mail);
        }

        // store final answer in sorted manner
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if (list[i].size() == 0)
                continue;

            Collections.sort(list[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String string : list[i])
                temp.add(string);

            ans.add(temp);
        }
        return ans;
    }


    public static void main(String[] args) {

    }
}
