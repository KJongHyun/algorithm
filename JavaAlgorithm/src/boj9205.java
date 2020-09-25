import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj9205 {

    static int MAX = 32768;
    static int INF = Integer.MAX_VALUE;
    static int[] d;
    static List<Pair<Integer, Integer>>[] nodeList;
    boolean[][] conv = new boolean[MAX][MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(bf.readLine());
        for (int i = 0; i < t; i++) {
            List<Pair<Integer, Integer>> xyList = new ArrayList<>();
            int n = Integer.valueOf(bf.readLine());
            d = new int[n + 3];
            Arrays.fill(d, INF);
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

            int hX = Integer.valueOf(st.nextToken());
            int hY = Integer.valueOf(st.nextToken());
            xyList.add(new Pair<>(hX, hY));



            for (int j = 1; j <= n; j++) {
                st = new StringTokenizer(bf.readLine(), " ");
                int cX = Integer.valueOf(st.nextToken());
                int cY = Integer.valueOf(st.nextToken());
                xyList.add(new Pair<>(cX, cY));
            }
            st = new StringTokenizer(bf.readLine(), " ");
            int rX = Integer.valueOf(st.nextToken());
            int rY = Integer.valueOf(st.nextToken());
            xyList.add(new Pair<>(rX, rY));

            nodeList = new ArrayList[n + 3];
            for (int nodeIndex = 0; nodeIndex <= n + 2; nodeIndex++) {
                nodeList[nodeIndex] = new ArrayList<>();
            }
            for (int listIndex = 0; listIndex < xyList.size(); listIndex++) {
                Pair<Integer, Integer> integerIntegerPair1 = xyList.get(listIndex);
                for (int listIndexIn = 0; listIndexIn < xyList.size(); listIndexIn++) {
                    if (listIndex == listIndexIn)
                        continue;
                    Pair<Integer, Integer> integerIntegerPair2 = xyList.get(listIndexIn);
                    int distance = Math.abs(integerIntegerPair1.getKey() - integerIntegerPair2.getKey()) + Math.abs(integerIntegerPair1.getValue() - integerIntegerPair2.getValue());

                    if (distance <= 1000) {
                        nodeList[listIndex + 1].add(new Pair<>(listIndexIn + 1, 1));
                        nodeList[listIndexIn + 1].add(new Pair<>(listIndex + 1, 1));
                    }
                }
            }

            dijkstra();

            if (d[n + 2] == INF)
                System.out.println("sad");
            else
                System.out.println("happy");

        }
    }


    public static void dijkstra() {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        d[1] = 0;
        q.add(new Pair(1, 0));
        while (!q.isEmpty()) {
            Pair<Integer, Integer> current = q.poll();

            for (int i = 0; i < nodeList[current.getKey()].size(); i++) {
                int next = nodeList[current.getKey()].get(i).getKey();
                int nextDistance = current.getValue() + nodeList[current.getKey()].get(i).getValue();

                if (d[next] > nextDistance) {
                    d[next] = nextDistance;
                    q.offer(new Pair<>(next, nextDistance));
                }
            }
        }
    }
}
