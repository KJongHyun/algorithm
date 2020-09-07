import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class pg64062 {

    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        System.out.println(solution2(stones, 3));
    }

    public static int solution(int[] stones, int k) {

        List<Integer> maxList = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        for (int stone : stones) {
            maxList.add(stone);

            if (maxList.size() >= k) {
                int target = getMax(maxList);
                if (target < min)
                    min = target;
                maxList = maxList.subList(1, maxList.size());
            }

        }

        return min;
    }


    public static int solution2(int[] stones, int k) {

        List<Integer> maxList = new ArrayList<>();

        int min = Integer.MAX_VALUE;

        Integer preMaxValue = null;
        int removeValue = 0;
        for (int stone : stones) {
            maxList.add(stone);

            if (maxList.size() >= k) {

                if (preMaxValue == null || preMaxValue == removeValue) {
                    preMaxValue = getMax(maxList);
                }

                if (preMaxValue < min)
                    min = preMaxValue;

                removeValue = maxList.get(0);
                maxList = maxList.subList(1, maxList.size());
            }

        }

        return min;
    }


    public static int getMax(List<Integer> maxList) {
        int max = 0;
        for (int data : maxList) {
            if (max < data)
                max = data;
        }

        return max;
    }

}
