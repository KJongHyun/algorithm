import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj9370 {

    static int INF = 100000000;
    static int n;
    static List<Graph>[] graphArr;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.valueOf(bf.readLine());

        for (int tI = 0; tI < T; tI++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            n = Integer.valueOf(st.nextToken());
            int m = Integer.valueOf(st.nextToken());
            int t = Integer.valueOf(st.nextToken());

            st = new StringTokenizer(bf.readLine(), " ");
            int s = Integer.valueOf(st.nextToken());
            int g = Integer.valueOf(st.nextToken());
            int h = Integer.valueOf(st.nextToken());

            graphArr = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graphArr[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine(), " ");
                int u = Integer.valueOf(st.nextToken());
                int v = Integer.valueOf(st.nextToken());
                int w = Integer.valueOf(st.nextToken());
                graphArr[u].add(new Graph(v, w));
                graphArr[v].add(new Graph(u, w));
            }

            List<Integer> candidateList = new ArrayList<>();

            for (int i = 0; i < t; i++) {
                int candidate = Integer.valueOf(bf.readLine());
                candidateList.add(candidate);
            }

            List<Integer> realResultList = new ArrayList<>();

            for (int candidate : candidateList) {
                int result1 = 0;
                int result2 = 0;

                result1 += dijkstra(s, g);
                result1 += dijkstra(g, h);
                result1 += dijkstra(h, candidate);

                result2 += dijkstra(s, h);
                result2 += dijkstra(h, g);
                result2 += dijkstra(g, candidate);

                int realResult = dijkstra(s, candidate);

                if (result1 == realResult || result2 == realResult) {
                    realResultList.add(candidate);
                }
            }


            Collections.sort(realResultList);

            for (int realResult : realResultList) {
                System.out.print(realResult + " ");
            }
            System.out.println();
        }

    }

    public static void solve() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        int t = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(bf.readLine(), " ");
        int s = Integer.valueOf(st.nextToken());
        int g = Integer.valueOf(st.nextToken());
        int h = Integer.valueOf(st.nextToken());

        graphArr = new ArrayList[n + 1];
        Arrays.fill(graphArr, new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            int w = Integer.valueOf(st.nextToken());
            graphArr[u].add(new Graph(v, w));
            graphArr[v].add(new Graph(u, w));
        }

        List<Integer> candidateList = new ArrayList<>();

        for (int i = 0; i < t; i++) {
            int candidate = Integer.valueOf(bf.readLine());
            candidateList.add(candidate);
        }

        List<Integer> realResultList = new ArrayList<>();

        for (int candidate : candidateList) {
            int result1 = 0;
            int result2 = 0;

            result1 += dijkstra(s, g);
            result1 += dijkstra(g, h);
            result1 += dijkstra(h, candidate);

            result2 += dijkstra(s, h);
            result2 += dijkstra(h, g);
            result2 += dijkstra(g, candidate);

            int realResult = dijkstra(s, candidate);

            if (result1 == realResult || result2 == realResult) {
                realResultList.add(candidate);
            }
        }


        Collections.sort(realResultList);

        for (int realResult : realResultList) {
            System.out.print(realResult + " ");
        }
    }

    public static int dijkstra(int start, int target) {
        int[] d = new int[n + 1];
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
                if (d[next] > nextDistance) {
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
