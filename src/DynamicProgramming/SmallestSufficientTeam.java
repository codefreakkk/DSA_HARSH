package DynamicProgramming;
import java.util.*;
public class SmallestSufficientTeam {

    private List<Integer> temp = new ArrayList<>();

    private void solve(int index, int mask, int targetMask, List<Integer> peoplesMask, List<Integer> ans, int[][] dp) {
        if (index == peoplesMask.size()) {
            if (mask == targetMask) {
                if (temp.size() == 0 || temp.size() > ans.size()) {
                    temp.removeAll(temp);
                    for (int val : ans) {
                        temp.add(val);
                    }
                }
            }
            return;
        }

        if (dp[index][mask] != -1) {
            if (dp[index][mask] <= ans.size()) {
                return;
            }
        }

        solve(index + 1, mask, targetMask, peoplesMask, ans, dp);

        ans.add(index);
        solve(index + 1, mask | peoplesMask.get(index), targetMask, peoplesMask, ans, dp);
        ans.remove(ans.size() - 1);

        dp[index][mask] = ans.size() != 0 ? ans.size() : -1;
    }

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> peoples) {
        int n = req_skills.length;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], i);
        }

        List<Integer> peoplesMask = new ArrayList<>();
        for (List<String> it : peoples) {
            int mask = 0;

            for (String people : it) {
                mask |= 1 << map.get(people);
            }
            peoplesMask.add(mask);
        }

        int targetMask = (1 << n) - 1;
        int[][] dp = new int[peoples.size() + 1][targetMask + 1];
        for (int[] dpRow : dp) {
            Arrays.fill(dpRow, -1);
        }

        List<Integer> ans = new ArrayList<>();
        solve(0, 0, targetMask, peoplesMask, ans, dp);

        return temp.stream().mapToInt(i->i).toArray();
    }

    public static void main(String[] args) {
    }
}
