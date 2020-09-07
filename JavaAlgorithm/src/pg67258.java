import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class pg67258 {

    public static void main(String[] args) {
        String[] gems1 = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        solution(gems1);
    }

    public static int[] solution(String[] gems) {
        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }

        int[] min = {1, gems.length};
        for (int i = 0; i < gems.length; i++) {
            Set<String> tempGemSet = new HashSet<>();
            for (int j = i; j < gems.length; j++) {
                tempGemSet.add(gems[j]);
                if (tempGemSet.size() == gemSet.size()) {
                    if (min[1] - min[0] > j - i) {
                        min[0] = i + 1;
                        min[1] = j + 1;
                        break;
                    }
                }
            }
        }

        return min;
    }

}
