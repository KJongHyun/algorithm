import java.util.ArrayList;
import java.util.List;

public class Line2020_3 {

    static List<DfsInfo> dfsInfoList = new ArrayList<>();

    public static void main(String[] args) {
        solution(3000);
    }

    public static int[] solution(int n) {
        dfs(String.valueOf(n), 0);
        int min = Integer.MAX_VALUE;
        DfsInfo minDfsInfo = null;
        for (DfsInfo dfsInfo : dfsInfoList) {
            if (dfsInfo.count < min) {
                min = dfsInfo.count;
                minDfsInfo = dfsInfo;
            }
        }
        int[] answer = {minDfsInfo.count, minDfsInfo.numb};
        return answer;
    }

    public static void dfs(String n, int count) {
        if (n.length() == 1) {
            dfsInfoList.add(new DfsInfo(Integer.valueOf(n), count));
            return;
        }

        for (int i = 1; i < n.length(); i++) {
            String first = n.substring(0, i);
            String second = n.substring(i);
            if (second.startsWith("00")) {
                continue;
            }
            int sum = Integer.valueOf(first) + Integer.valueOf(second);
            dfs(String.valueOf(sum), count + 1);
        }
    }

    static class DfsInfo {
        int count;
        int numb;


        public DfsInfo(int numb, int count) {
            this.numb = numb;
            this.count = count;
        }
    }
}
