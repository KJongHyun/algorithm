import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KakaoEnter3 {
    public static void main(String[] args) {
        List<Integer> space = new ArrayList<>();
        space.add(1);
        space.add(1);
        space.add(1000000000);
        System.out.println(segment(1, space));
    }

    public static int segment(int x, List<Integer> space) {
        List<Integer> minList = new ArrayList<>();
        int lengthX = x;
        for (int i = 0; i < space.size() && lengthX <= space.size(); i++) {
            List<Integer> integers = space.subList(i, lengthX);
            int min = Collections.min(integers);
            minList.add(min);
            lengthX++;
        }

        int max = Collections.max(minList);

        return max;
    }
}
