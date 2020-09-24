import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj2644 {

    static int n;
    static int m;
    static int a;
    static int b;
    static Person[] familyList;
    static boolean[] visited;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(bf.readLine());

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        a = Integer.valueOf(st.nextToken());
        b = Integer.valueOf(st.nextToken());

        m = Integer.valueOf(bf.readLine());

        familyList = new Person[n + 1];

        for (int i = 0; i <= n; i++) {
            familyList[i] = new Person();
        }

        visited = new boolean[n + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            int x = Integer.valueOf(st.nextToken());
            int y = Integer.valueOf(st.nextToken());

            familyList[x].children.add(y);
            familyList[y].parent = x;
        }

        dfs(a, b, 0);
        System.out.println(result);
    }


    public static void dfs(int x, int y, int depth) {

        if (visited[x])
            return;

        if (x == y) {
            result = depth;
            return;
        }

        visited[x] = true;
        dfs(familyList[x].parent, y, depth + 1);
        for (int i = 0; i < familyList[x].children.size(); i++) {
            dfs(familyList[x].children.get(i), y, depth + 1);
        }

    }

    static class Person {
        int parent;
        List<Integer> children = new ArrayList<>();
    }


}
