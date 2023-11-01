package CODES;

import java.util.*;
import java.io.*;

public class BMC_2 {
    public static Map<String,Integer> processData(ArrayList<String> array) {

        Map<String,Integer> ans = new HashMap<String,Integer>();
        Map<String, Map<Integer, Integer>> map = new HashMap<>();

        int n = array.size();
        for (int i = 0; i < n; i++) {
            String[] str = array.get(i).split(",");
            String event = str[2].trim();

            if (!map.containsKey(event)) {
                map.put(event, new HashMap<>());
            }
            map.get(event).put(Integer.parseInt(str[3].trim()), Integer.parseInt(str[4].trim()));
        }

        for (Map.Entry<String, Map<Integer, Integer>> mp : map.entrySet()) {
            Map<Integer, Integer> data = map.get(mp.getKey());

            // get score
            int max = -1, score = -1;
            for (Map.Entry<Integer, Integer> maxTime : data.entrySet()) {
                if (maxTime.getKey() > max) {
                    max = maxTime.getKey();
                    score = maxTime.getValue();
                }
            }
            ans.put(mp.getKey(), score);
        }
        return ans;
    }

    public static void main (String[] args) {
        ArrayList<String> inputData = new ArrayList<String>();
        String line;
        try {
            Scanner in = new Scanner(new BufferedReader(new FileReader("./src/CODES/input.txt")));
            while(in.hasNextLine())
                inputData.add(in.nextLine());

            Map<String,Integer> retVal = processData(inputData);
            PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter("./src/CODES/output.txt")));
            for(Map.Entry<String,Integer> e: retVal.entrySet())
                output.println(e.getKey() + ": " + e.getValue());
            output.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}