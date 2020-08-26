import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj5014 {
    public static void main(String[] args) throws IOException {
        int F, S, G, U, D;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.valueOf(st.nextToken());
        S = Integer.valueOf(st.nextToken());
        G = Integer.valueOf(st.nextToken());
        U = Integer.valueOf(st.nextToken());
        D = Integer.valueOf(st.nextToken());
        System.out.println(solution(F, S, G, U, D));
    }

    public static String solution(Integer F, Integer S, Integer G, Integer U, Integer D) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(S, 0));
        boolean[] visited = new boolean[F + 1];
        while (!q.isEmpty()) {
            Info info = q.poll();
            if (info.S == G)
                return String.valueOf(info.count);
            if (info.S + U <= F && !visited[info.S + U]) {
                q.add(new Info(info.S + U, info.count + 1));
                visited[info.S + U] = true;
            }

            if (info.S - D >= 1 && !visited[info.S - D]) {
                q.add(new Info(info.S - D, info.count + 1));
                visited[info.S - D] = true;
            }
        }

        return "use the stairs";

    }

    static class Info {

        int S;
        int count;

        public Info(int S, int count) {
            this.S = S;
            this.count =count;
        }
    }
}
