import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj1504 {

    static int INF = 1000000000;
    static int[] d;
    static List<Graph>[] graphArr;
    static int vertexCount;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        vertexCount = Integer.valueOf(st.nextToken());
        int edgeCount = Integer.valueOf(st.nextToken());

        graphArr = new ArrayList[vertexCount + 1];

        for (int i = 1; i <= vertexCount; i++) {
            graphArr[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCount; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            int w = Integer.valueOf(st.nextToken());
            graphArr[u].add(new Graph(v, w));
            graphArr[v].add(new Graph(u, w));
        }

        st = new StringTokenizer(bf.readLine(), " ");
        int v1 = Integer.valueOf(st.nextToken());
        int v2 = Integer.valueOf(st.nextToken());



        int result1 = 0;
        int result2 = 0;
        result1 += dijkstra(1, v1);
        result1 += dijkstra(v1, v2);
        result1 += dijkstra(v2, vertexCount);

        result2 += dijkstra(1, v2);
        result2 += dijkstra(v2, v1);
        result2 += dijkstra(v1, vertexCount);

        if (result1 == INF && result2 == INF) {
            System.out.println(-1);
        } else {

            System.out.println(result1 > result2 ? result2 : result1);
        }
    }

    public static int dijkstra(int start, int target) {
        d = new int[vertexCount + 1];
        Arrays.fill(d, INF);
        d[start] = 0;
        PriorityQueue<Graph> q = new PriorityQueue<>();
        q.offer(new Graph(start, 0));
        while (!q.isEmpty()) {
            Graph current = q.poll();

            if (d[current.v] < current.w)
                continue;

            for (int i = 0; i < graphArr[current.v].size(); i++) {
                int next = graphArr[current.v].get(i).v;
                int nextDistance = current.w + graphArr[current.v].get(i).w;
                if (nextDistance < d[next]) {
                    d[next] = nextDistance;
                    q.offer(new Graph(next, nextDistance));
                }
            }
        }


        return d[target];
    }


    static class Graph implements Comparable<Graph> {
        int v;
        int w;

        public Graph(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Graph o) {
            return this.w > o.w ? 1 : -1;
        }
    }
}
