package CognologixTask;
import java.util.*;

public class Problem4 {

    class Data {
        String server, type, packageName, version;
        public Data(String server, String type, String packageName, String version) {
            this.server = server;
            this.type = type;
            this.packageName = packageName;
            this.version = version;
        }
    }

    public void addRawData(List<Data> data) {
        data.add(new Data("Server1", "Database", "MySQL", "5.5"));
        data.add(new Data("Server2", "Database", "MySQL", "5.1"));
        data.add(new Data("Server3", "OS", "Ubuntu", "12.04"));
        data.add(new Data("Server1", "OS", "Ubuntu", "12.04"));
        data.add(new Data("Server2", "OS", "Ubuntu", "18.04"));
        data.add(new Data("Server3", "Language", "Python", "2.6.3"));
    }

    public List<String> getOutDatedVersion() {
        List<Data> data = new ArrayList<>();
        addRawData(data);

        // store frequency of packages
        HashMap<String, Integer> packageFrequency = new HashMap<>();
        for (Data iterator : data) {
            packageFrequency.put(iterator.packageName, packageFrequency.getOrDefault(iterator.packageName, 0) + 1);
        }

        // store versions of package
        HashMap<String, List<String>> packageVersion = new HashMap<>();
        for (Data iterator : data) {
            if (packageVersion.containsKey(iterator.packageName)) {
                packageVersion.get(iterator.packageName).add(iterator.version);
            }
            else {
                List<String> temp = new ArrayList<>();
                temp.add(iterator.version);
                packageVersion.put(iterator.packageName, temp);
            }
        }

        // iterate over package and find ans
        List<String> ans = new ArrayList<>();
        for (Map.Entry<String, Integer> map : packageFrequency.entrySet()) {
            String packageName = map.getKey();

            if (map.getValue() > 2) {
                List<String> list = packageVersion.get(packageName);
                String version = list.get(0);

                for (int i = 1; i < list.size(); i++) {
                    if (!version.equals(list.get(i))) {
                        ans.add(packageName);
                        break;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem4 o = new Problem4();
        List<String> list = o.getOutDatedVersion();

        for (String ans : list) {
            System.out.println(ans);
        }
    }
}
