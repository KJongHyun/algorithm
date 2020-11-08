import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KakaoEnter2 {

    public static void main(String[] args) {
        List<Integer> timestamp = new LinkedList<Integer>(Arrays.asList(2, 1, 1, 1, 1, 1, 1));
        List<Integer> top = Arrays.asList(1, 1);
        System.out.println(requestsServed(timestamp, top));
    }

    public static int requestsServed(List<Integer> timestamp, List<Integer> top) {
        int processCount = 0;
        Collections.sort(timestamp);
        Collections.sort(top);
        for (int t = 0; t < top.size(); t++) {
            int startResponseIndex = -1;
            for (int i = timestamp.size() - 1; i >= 0; i--) {
                if (top.get(t) >= timestamp.get(i)) {
                    startResponseIndex = i;
                    break;
                }
            }
            int removeCount = startResponseIndex >= 4 ? 5 : startResponseIndex + 1;
            for (int r = 0; r < removeCount; r++) {
                timestamp.remove(startResponseIndex - r);
                processCount++;
            }
        }

        return processCount;
    }
}
