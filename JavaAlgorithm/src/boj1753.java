import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj1753 {

    static int INF = 100000000;
    static int[] d;
    static List<Node>[] nodeArray;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] split = bf.readLine().split(" ");
        int vCount = Integer.valueOf(split[0]);
        int eCount = Integer.valueOf(split[1]);
        int startVertex = Integer.valueOf(bf.readLine());

        nodeArray = new ArrayList[vCount + 1];

        for (int i = 1; i <= vCount; i++) {
            nodeArray[i] = new ArrayList<>();
        }

        for (int i = 0; i < eCount; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            int w = Integer.valueOf(st.nextToken());
            nodeArray[u].add(new Node(u, v, w));
        }


        d = new int[vCount + 1];

        for (int i = 1; i <= vCount; i++) {
            d[i] = INF;
        }

        dijkstra(startVertex);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= vCount; i++) {
            if (d[i] == INF)
                bw.write("INF\n");
            else
                bw.write(d[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dijkstra(int start) {
        d[start] = 0;
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(start, start, 0));
        while (!q.isEmpty()) {
            Node node = q.poll();
            int current = node.target;
            int distance = node.cost;

            if (d[current] < distance)
                continue;

            for (int i = 0; i < nodeArray[current].size(); i++) {
                int next = nodeArray[current].get(i).target;
                int nextDistance = distance + nodeArray[current].get(i).cost;
                if (nextDistance < d[next]) {
                    d[next] = nextDistance;
                    q.offer(new Node(start, next, nextDistance));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int start;
        int target;
        int cost;

        public Node(int start, int target, int cost) {
            this.start = start;
            this.target = target;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost > node.cost ? 1 : -1;
        }
    }


}
