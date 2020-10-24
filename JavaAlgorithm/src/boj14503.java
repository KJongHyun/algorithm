import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14503 {
    static boolean isTurnOn = true;

    static int[][] left = {
            // r, c
            // 북
            {0, -1},
            // 동
            {-1, 0},
            // 남
            {0, 1},
            // 서
            {1, 0}
    };

    static int[][] back = {
            // 북
            {1, 0},
            // 동
            {0, -1},
            // 남
            {-1, 0},
            // 서
            {0, 1}
    };
    static int[][] map;
    static boolean[][] cleaned;
    static int cleanCount = 0;
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(bf.readLine(), " ");

        int r = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());
        int d = Integer.valueOf(st.nextToken());

        map = new int[n][m];
        cleaned = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }

        dfs(r, c, d, false);

        System.out.println(cleanCount);
    }

    public static void dfs(int r, int c, int d, boolean isBack) {
        if (!isTurnOn)
            return;
        if (!cleaned[r][c] && map[r][c] == 0) {
            cleaned[r][c] = true;
            cleanCount++;
        }

        int turnCount = 0;

        boolean isDetect = false;
        while(!isDetect && turnCount < 4) {
            int newR = r + left[d][0];
            int newC = c + left[d][1];
            d = getDirectionBeforeTurn(d);
            if (newR >= 0 && newC >= 0 && newR < n && newC < m && map[newR][newC] == 0 && !cleaned[newR][newC]) {
                isDetect = true;
                dfs(newR, newC, d, false);
            }

            turnCount++;
        }

        int newR = r + back[d][0];
        int newC = c + back[d][1];
        if (newR >= 0 && newC >= 0 && newR < n && newC < m && map[newR][newC] == 0) {
            dfs(newR, newC, d, true);
        } else {
            isTurnOn = false;
        }

        return;
    }

    public static int getDirectionBeforeTurn(int d) {
        if (d == 0) { // 북
            return 3;
        } else if (d == 1) { // 동
            return 0;
        } else if (d == 2) { // 남
            return 1;
        } else if (d == 3) { // 서
            return 2;
        }

        return 0;
    }
}
