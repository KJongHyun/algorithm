import java.util.*;

public class Coupang3 {

    public static void main(String[] args) {
        int k = 2;
        int[] score = {1300000000,700000000,668239490,618239490,568239490,568239486,518239486,157658638,157658634,100000000,100};
        System.out.println(solution(k, score));
    }

    public static int solution(int k, int[] score) {
        HashMap<Integer, Set<Integer>> gapMap = new HashMap<>();

        HashMap<Integer, Integer> scoreMap = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            scoreMap.put(i + 1, score[i]);
        }

        for (int i = 0; i < score.length - 1; i++) {
            int firstScore = score[i];
            int secondScore = score[i + 1];
            int gap = Math.abs(firstScore - secondScore);
            if (!gapMap.containsKey(gap)) {
                gapMap.put(gap, new HashSet<>());
            }
            gapMap.get(gap).add(i + 1);
            gapMap.get(gap).add(i + 2);

        }

        for (Integer key : gapMap.keySet()) {
            Set<Integer> rankSet = gapMap.get(key);
            if (Math.ceil(rankSet.size() / 2.0) >= k) {
                for (int rank : rankSet) {
                    scoreMap.remove(rank);
                }
            }
        }

        return scoreMap.size();
    }
}
