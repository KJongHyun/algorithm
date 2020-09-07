import java.util.*;

public class pg64064 {

    static boolean[] visited;
    static Set<String> ori;
    public static void main(String[] args) {
        String[] user_id = { "frodo", "fradi", "crodo", "abc123", "frodoc" };
        System.out.println(solution(user_id, new String[] { "fr*d*", "*rodo", "******", "******" }));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        int ans = 1;
        visited = new boolean[user_id.length];
        List<UserIdInfo> userIdList = new ArrayList<>();
        int index = 0;
        for (String userId : user_id) {
            userIdList.add(new UserIdInfo(userId, index++));
        }

        List<List<UserIdInfo>> userIdInfoLists = new ArrayList<>();

        for (String bannedId : banned_id) {
            userIdInfoLists.add(correctNumber(userIdList, bannedId));
        }

        ori = new HashSet<>();
        checkCase(0, userIdInfoLists);

        return ori.size();

    }

    public static List<UserIdInfo> correctNumber(List<UserIdInfo> userIdList, String bannedId) {
        List<UserIdInfo> checkList = new ArrayList<>();

        for (UserIdInfo userIdInfo : userIdList) {
            checkList.add(userIdInfo);
        }


        // 길이 체크
        checkList.removeIf(i -> i.userId.length() != bannedId.length());

        for (int i = 0; i < bannedId.length(); i++) {
            int finalI = i;
            checkList.removeIf(userId -> checkChar(userId.userId.charAt(finalI), bannedId.charAt(finalI)));
        }

        return checkList;
    }


    public static void checkCase(int start, List<List<UserIdInfo>> userIdInfoLists) {
        if (start == userIdInfoLists.size()) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    sb.append(String.valueOf(i));
                }
            }
            ori.add(sb.toString());
            return;
        }

            List<UserIdInfo> userIdInfoList = userIdInfoLists.get(start);
            for (UserIdInfo userIdInfo : userIdInfoList) {
                if (!visited[userIdInfo.index]) {
                    visited[userIdInfo.index] = true;
                    checkCase(start + 1, userIdInfoLists);
                    visited[userIdInfo.index] = false;
                }
            }

    }

    public static boolean checkChar(char userId, char bannedId) {
        if (bannedId == '*')
            return false;
        return userId != bannedId;
    }



    static class UserIdInfo {
        String userId;
        int index;

        public UserIdInfo(String userId, int index) {
            this.userId = userId;
            this.index = index;
        }
    }
}
