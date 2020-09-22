import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class boj11657 {

    static int vertexCount;
    static int edgeCount;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        vertexCount = Integer.valueOf(st.nextToken());
        edgeCount = Integer.valueOf(st.nextToken());

        List<Pair<Integer, Integer>>[] edgeArr = new ArrayList[vertexCount + 1];

        for (int i = 1; i <= vertexCount; i++) {
            edgeArr[i] = new ArrayList<>();
        }

        for (int i = 1; i <= edgeCount; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            int w = Integer.valueOf(st.nextToken());

            edgeArr[u].add(new Pair<>(v, w));
        }

        long[] d = new long[vertexCount + 1];
        Arrays.fill(d, INF);
        d[1] = 0;

        boolean isUpdate = false;

        for (int count = 1; count <= vertexCount; count++) {
            for (int v = 1; v <= vertexCount; v++) {
                for (int e = 0; e < edgeArr[v].size(); e++) {
                    int next = edgeArr[v].get(e).getKey();
                    int nextCost = edgeArr[v].get(e).getValue();
                    // d[v] -> INF 일때에 nextCost가 음수라면 더 작기 때문에 갱신되어버림 하지만, INF는 갈 수 없는 곳(무한의 의미)로 앞의 반례 처럼 음수 cost에 의해 갱신되어버리면 오류가 생김
                    // 그리하여 d[v] != INF 일때만 뒤에 조건 판별
                    if (d[v] != INF && d[next] > d[v] + nextCost) {
                        if (count == vertexCount) {
                            isUpdate = true;
                            break;
                        }
                        d[next] = d[v] + nextCost;

                    }
                }
            }
        }

        if (isUpdate) {
            System.out.println(-1);
        } else {
            for (int i = 2; i <= vertexCount; i++) {
                System.out.println(d[i] == INF ? -1 : d[i]);
            }
        }

    }

}
