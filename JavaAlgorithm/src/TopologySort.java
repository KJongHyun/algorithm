import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologySort {

    static int n;
    static int MAX = 10;
    static int[] inDegree = new int[MAX];
    static List<Integer>[] a = new ArrayList[MAX];

    public static void main(String[] args) {
        for (int i = 0; i < MAX; i++) {
            a[i] = new ArrayList<>();
        }
        n = 7;
        a[1].add(2);
        inDegree[2]++;
        a[1].add(5);
        inDegree[5]++;
        a[2].add(3);
        inDegree[3]++;
        a[3].add(4);
        inDegree[4]++;
        a[4].add(6);
        inDegree[6]++;
        a[5].add(6);
        inDegree[6]++;
        a[6].add(7);
        inDegree[7]++;


        topologySort();
    }

    public static void topologySort() {

        int[] result = new int[MAX];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        boolean isCycle = false;
        for (int i = 1; i <= n; i++) {
            if (q.isEmpty()) {
                isCycle = true;
                return;
            }

            int x = q.poll();
            result[i] = x;
            for (int j = 0; j < a[x].size(); j++) {
                int y = a[x].get(j);

                // 현재 진입차수가 0인 x 와 연결된 엣지를 끊으면서 연결된 y의 진입차수가 0인경우 q에 삽입
                // 새롭게 진입 차수가 0이 된 정점을 큐에 삽입합니다.
                if (--inDegree[y] == 0) {
                    q.offer(y);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.print(result[i] + " ");
        }
    }

}
