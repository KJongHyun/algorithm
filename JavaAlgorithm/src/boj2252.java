import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2252 {

    static int n;
    static int m;
    static int[] inDegree;
    static List<Integer>[] verTexList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        inDegree = new int[n + 1];
        verTexList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            verTexList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            verTexList[a].add(b);
            inDegree[b]++;
        }

        topologySort();

    }

    public static void topologySort() {
        int[] result = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        for (int i = 1; i <= n; i++) {
            int x = q.poll();
            result[i] = x;
            for (int j = 0; j < verTexList[x].size(); j++) {
                int y = verTexList[x].get(j);
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
