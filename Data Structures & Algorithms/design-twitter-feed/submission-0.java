class Twitter {
    HashMap<Integer, List<Integer>> uidTweets;
    HashMap<Integer, List<Integer>> follows;
    HashMap<Integer, List<Integer>> followers;

    public Twitter() {
        uidTweets = new HashMap<>();
        follows = new HashMap<>();
        followers = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        List<Integer> userTweets =
            uidTweets.getOrDefault(userId, new ArrayList<>());

        userTweets.add(tweetId);
        uidTweets.put(userId, userTweets);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> allTweets = new ArrayList<>();

        allTweets.addAll(
            uidTweets.getOrDefault(userId, new ArrayList<>())
        );

        // Include tweets from users they follow.
        List<Integer> followsList =
            follows.getOrDefault(userId, new ArrayList<>());

        for (int followeeId : followsList) {
            allTweets.addAll(
                uidTweets.getOrDefault(followeeId, new ArrayList<>())
            );
        }

        allTweets.sort(Collections.reverseOrder());

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < Math.min(10, allTweets.size()); i++) {
            result.add(allTweets.get(i));
        }

        return result;
    }

    public void follow(int followerId, int followeeId) {
        List<Integer> followsList =
            follows.getOrDefault(followerId, new ArrayList<>());

        if (!followsList.contains(followeeId)) {
            followsList.add(followeeId);
            follows.put(followerId, followsList);

            List<Integer> followersList =
                followers.getOrDefault(followeeId, new ArrayList<>());

            followersList.add(followerId);
            followers.put(followeeId, followersList);
        }
    }

    public void unfollow(int followerId, int followeeId) {
        List<Integer> followsList = follows.get(followerId);
        if (followsList != null) {
            followsList.remove(Integer.valueOf(followeeId));
        }

        List<Integer> followersList = followers.get(followeeId);
        if (followersList != null) {
            followersList.remove(Integer.valueOf(followerId));
        }
    }
}