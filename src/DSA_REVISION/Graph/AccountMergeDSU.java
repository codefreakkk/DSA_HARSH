package DSA_REVISION.Graph;

import java.util.*;

public class AccountMergeDSU {
    public List<List<String>> accountMerge(List<List<String>> accounts) {
        int V = accounts.size();
        DisjointSet ds = new DisjointSet(accounts.size());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (map.containsKey(mail)) {
                    ds.unionBySize(i, map.get(mail));
                } else {
                    map.put(mail, i);
                }
            }
        }

        List<String>[] list = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            list[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String mail = entry.getKey();
            int node = entry.getValue();
            int parentNode = ds.findParent(node);
            list[parentNode].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (list[i].isEmpty()) {
                continue;
            }
            Collections.sort(list[i]);
            list[i].set(0, accounts.get(i).get(0));
            ans.add(list[i]);
        }
        return ans;
    }
}
