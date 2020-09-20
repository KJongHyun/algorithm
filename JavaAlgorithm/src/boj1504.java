import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1504 {

    static int INF = 100000000;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        int vertexCount = Integer.valueOf(st.nextToken());
        int edgeCount = Integer.valueOf(st.nextToken());

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            int w = Integer.valueOf(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine(), " ");
        int v1 = Integer.valueOf(st.nextToken());
        int v2 = Integer.valueOf(st.nextToken());

        d = new int[vertexCount + 1];
        Arrays.fill(d, INF);

        int result1 = 0;
        int result2 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, vertexCount);

        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, vertexCount);


        System.out.println(result1 > result2 ? result2 : result1);
    }

    public static int dijkstra(int start, int target) {
        int ans = 0;

        return ans;
    }


}
