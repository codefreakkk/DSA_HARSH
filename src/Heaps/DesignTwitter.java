package Heaps;

import java.util.*;

public class DesignTwitter {
    public HashMap<Integer, User> userMap;
    public static int timeStamp;
    class Tweet {
        int id, time;
        Tweet next;
        public Tweet(int id) {
            this.id = id;
            this.next = null;
            this.time = timeStamp++;
        }

    }
    class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweetHead;

        public User(int id) {
            this.id = id;
            this.tweetHead = null;
            this.followed = new HashSet<>();
            this.follow(id);
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int tweetId) {
            Tweet tweet = new Tweet(tweetId);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    public DesignTwitter() {
        this.userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        // if user not created then create it first
        if (!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ans = new ArrayList<>();

        // if no user found return empty list
        if (!userMap.containsKey(userId))
            return ans;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        for (int user : users) {
            Tweet tweet = userMap.get(user).tweetHead;
            if (tweet != null)
                pq.offer(tweet);
        }

        // get recent 10 tweet
        for (int i = 0; i < 10 && !pq.isEmpty(); i++) {
            Tweet tweet = pq.poll();
            ans.add(tweet.id);
            if (tweet.next != null)
                pq.offer(tweet.next);
        }
        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if (!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId) || followerId == followeeId)
            return;

        userMap.get(followerId).unfollow(followeeId);
    }
    public static void main(String[] args) {

    }
}
