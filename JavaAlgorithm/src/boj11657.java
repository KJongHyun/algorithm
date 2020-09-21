import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj11657 {

    static int vertexCount;
    static int edgeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        vertexCount = Integer.valueOf(st.nextToken());
        edgeCount = Integer.valueOf(st.nextToken());

        List<Pair<Integer, Integer>>[] edgeArr = new ArrayList[vertexCount + 1];

        for (int i = 1; i <= edgeArr.length; i++) {
            edgeArr[i] = new ArrayList<>();
        }


    }

}
