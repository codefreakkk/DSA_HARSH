package CognologixTask;
import java.util.*;

public class Problem3 {

    class Votes {
        int candidateId, votes;
        String name, constituency;
        public Votes(int candidateId, String name, String constituency, int votes) {
            this.candidateId = candidateId;
            this.name = name;
            this.constituency = constituency;
            this.votes = votes;
        }
    }

    public void addRawData(List<Votes> data) {
        data.add(new Votes(22, "Ravi Pawar", "Aundh", 1603));
        data.add(new Votes(23, "Suvarna Kale", "Baner", 803));
        data.add(new Votes(23, "Suvarna Kale", "Baner", 803));
        data.add(new Votes(29, "Vasant Mahajan", "Aundh", 617));
        data.add(new Votes(32, "Aarti Patil", "Baner", 351));
        data.add(new Votes(34, "Swaran Bijur", "Baner", 352));
    }

    public Map<String, Integer> maxVotesInConstituency() {
        List<Votes> data = new ArrayList<>();
        addRawData(data);

        Set<String> set = new HashSet<>();
        for (Votes iterator : data) {
            set.add(iterator.constituency);
        }

        Map<String, Integer> ans = new HashMap<>();
        for (String constituency : set) {
            int votes = -1, candidateId = -1;

            for (Votes vote : data) {
                if (vote.constituency.equals(constituency) && vote.votes > votes) {
                    votes = vote.votes;
                    candidateId = vote.candidateId;
                }
            }
            ans.put(constituency, candidateId);
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem3 o = new Problem3();
        System.out.println(o.maxVotesInConstituency());
    }
}
