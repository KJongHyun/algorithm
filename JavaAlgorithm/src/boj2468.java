import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2468 {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[][] interval = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(bf.readLine());

        map =  new int[n + 1][n + 1];

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 1; j <= n; j++) {
                int value = Integer.valueOf(st.nextToken());
                map[i][j] = value;
                if (value > max)
                    max = value;
            }
        }

        int maxSafetyZoneCount = Integer.MIN_VALUE;
        int maxRainHeight = 0;
        for (int rainHeight = 0; rainHeight <= max; rainHeight++) {
            visited = new boolean[n + 1][n + 1];
            int safetyZoneCount = 0;
            for (int row = 1; row <= n; row++) {
                for (int column = 1; column <= n; column++) {
                    if (!visited[row][column] && map[row][column] > rainHeight) {
                        visited[row][column] = true;
                        dfs(row , column, rainHeight);
                        safetyZoneCount++;
                    }
                }
            }

            if (safetyZoneCount > maxSafetyZoneCount) {
                maxSafetyZoneCount = safetyZoneCount;
                maxRainHeight = rainHeight;
            }
        }

        System.out.println(maxSafetyZoneCount);
    }

    public static void dfs(int y, int x, int rainHeight) {
        for (int i = 0; i < 4; i++) {
            int dx = x + interval[i][0];
            int dy = y + interval[i][1];

            if (dx > 0 && dx <= n && dy > 0 && dy <= n && !visited[dy][dx] && map[dy][dx] > rainHeight) {
                visited[dy][dx] = true;
                dfs(dy, dx, rainHeight);
            }
        }
    }

}
