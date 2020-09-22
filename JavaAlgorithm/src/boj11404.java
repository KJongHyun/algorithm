import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj11404 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int vertexCount = Integer.valueOf(bf.readLine());
        int edgeCount = Integer.valueOf(bf.readLine());

        List<Pair<Integer, Integer>>[] vertexArr = new ArrayList[vertexCount + 1];

        for (int i = 1; i <= vertexCount; i++) {
            vertexArr[i] = new ArrayList<>();
        }

        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int u = Integer.valueOf(st.nextToken());
            int v = Integer.valueOf(st.nextToken());
            int w = Integer.valueOf(st.nextToken());
            vertexArr[u].add(new Pair<>(v, w));
        }


        long[][] d = new long[vertexCount + 1][vertexCount + 1];

        int INF = 987654321;

        for (int i = 1; i <= vertexCount; i++) {
            for (int j = 1; j <= vertexCount; j++) {
                d[i][j] = i == j ? 0 : INF;
            }
        }

        for (int i = 1; i <= vertexCount; i++) {
            for (int j = 0; j < vertexArr[i].size(); j++) {
                int v = vertexArr[i].get(j).getKey();
                int w = vertexArr[i].get(j).getValue();
                d[i][v] = d[i][v] > w ? w : d[i][v];
            }
        }

        for (int k = 1; k <= vertexCount; k++) {
            for (int i = 1; i <= vertexCount; i++) {
                for (int j = 1; j <= vertexCount; j++) {
                    if (d[i][j]  > d[i][k] + d[k][j]) {
                        d[i][j]  = d[i][k] + d[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= vertexCount; i++) {
            for (int j = 1; j <= vertexCount; j++) {
                if (d[i][j] == INF) {
                    System.out.print("0 ");
                } else {
                    System.out.print(d[i][j] + " ");
                }

            }
            System.out.println();
        }
    }



}
