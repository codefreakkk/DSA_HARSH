package JUST_CODES;

import java.util.*;

public class NamingACompany {
    public long distinctNames(String[] ideas) {
        Set<String> set[] = new HashSet[26];
        for (int i = 0; i < 26; i++)
            set[i] = new HashSet<>();

        for (String idea : ideas)
            set[idea.charAt(0) - 'a'].add(idea.substring(1));

        long ans = 0;
        for (int i = 0; i < 25; i++) {
            for (int j = i + 1; j < 26; j++) {
                int count = 0;
                for (String s : set[i]) {
                    if (set[j].contains(s)) count++;
                }
                ans += 2 * (set[i].size() - count) * (set[j].size() - count);
            }
        }
        return ans;
    }
    public static void main(String[] args) {

    }
}
