package CODES;
import java.util.*;
public class UBS_PLACEMENT_1 {
    public static List<Integer> maxUpgradedServers(List<Integer> numServers, List<Integer> money,
                                                   List<Integer> upgrade, List<Integer> sell) {
        int n = numServers.size();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // Calculate the maximum number of servers that can be upgraded for the i-th network
            int maxUpgraded = Math.min(numServers.get(i), money.get(i) / upgrade.get(i));

            // Deduct the cost of upgrades from available funds
            int fundsLeft = money.get(i) - maxUpgraded * upgrade.get(i);

            // Calculate the number of servers that can be sold to add funds
            int sellableServers = fundsLeft / sell.get(i);

            // Add the minimum of maxUpgraded and sellableServers to the result list
            result.add(Math.min(maxUpgraded, sellableServers));
        }

        return result;
    }

    public static void main(String[] args) {
            List<Integer> numServers = List.of(12);
            List<Integer> money = List.of(12);
            List<Integer> upgrade = List.of(2);
            List<Integer> sell = List.of(2);

            List<Integer> result = maxUpgradedServers(numServers, money, upgrade, sell);
            System.out.println("Maximum upgraded servers for each network: " + result);
    }
}
