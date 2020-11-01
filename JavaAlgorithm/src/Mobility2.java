import java.util.*;

public class Mobility2 {

    public static void main(String[] args) {
        String[][] friends = {{"david","frank"}, {"demi", "david"}, {"frank", "james"}, {"demi", "james"}, {"claire", "frank"}};
        String user_id = "david";

        String[][] friends2 = {{"david", "demi"}, {"frank", "demi"}, {"demi", "james"}};
        String user_id2 = "frank";
        String[] solution = solution(friends2, user_id2);
    }

    public static String[] solution(String[][] friends, String user_id) {
        Map<String, FriendInfo> friendInfoMap = new HashMap<>();
        for (String[] friendRelation : friends) {
            for (String name : friendRelation) {
                if (!friendInfoMap.containsKey(name))
                    friendInfoMap.put(name, new FriendInfo());
            }
            friendInfoMap.get(friendRelation[0]).insertFriend(friendRelation[1]);
            friendInfoMap.get(friendRelation[1]).insertFriend(friendRelation[0]);
        }

        FriendInfo targetFriendInfo = friendInfoMap.get(user_id);
        for (String friend : targetFriendInfo.directFriends) {
            FriendInfo directFriendInfo = friendInfoMap.get(friend);
            Set<String> mutualFriendsOfTarget = directFriendInfo.directFriends;
            for (String mutualFriendName : mutualFriendsOfTarget) {
                if (!mutualFriendName.equals(user_id) && !targetFriendInfo.directFriends.contains(mutualFriendName)) {
                    targetFriendInfo.insertMutualFriend(mutualFriendName);
                }
            }
        }

        List<String> keySetList = new ArrayList<>(targetFriendInfo.mutualFriends.keySet());

        Collections.sort(keySetList, Comparator.comparing(o -> targetFriendInfo.mutualFriends.get(o)));

        TreeSet<String> maxMutualFriend = new TreeSet<>();
        Integer mutualCount = null;
        for (String key : targetFriendInfo.mutualFriends.keySet()) {
            if (mutualCount == null)
                mutualCount = targetFriendInfo.mutualFriends.get(key);
            if (targetFriendInfo.mutualFriends.get(key) == mutualCount)
                maxMutualFriend.add(key);
        }

        return maxMutualFriend.toArray(new String[maxMutualFriend.size()]);
    }

    static class FriendInfo {
        Set<String> directFriends = new HashSet<>();
        HashMap<String, Integer> mutualFriends = new HashMap<>();
        public void insertFriend(String friendName) {
            directFriends.add(friendName);
        }

        public void insertMutualFriend(String friendName) {
            if (mutualFriends.containsKey(friendName)) {
                mutualFriends.put(friendName, mutualFriends.get(friendName) + 1);
            } else {
                mutualFriends.put(friendName, 1);
            }
        }
    }
}


