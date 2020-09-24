import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj2573 {

    static int[][] iceberg;
    static List<Ice> iceList;
    static int row;
    static int column;
    static int[][] interval = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        row = Integer.valueOf(st.nextToken());
        column = Integer.valueOf(st.nextToken());

        iceberg = new int[row][column];

        iceList = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < column; j++) {
                int value = Integer.valueOf(st.nextToken());
                if (value != 0)
                    iceList.add(new Ice(j, i, value));
                iceberg[i][j] = value;
            }
        }

        System.out.println(solve());

    }

    public static int surroundSeaCount(Ice ice) {
        int count = 0;
        // 위
        if (iceberg[ice.y - 1][ice.x] == 0)
            count++;
        // 아래
        if (iceberg[ice.y + 1][ice.x] == 0)
            count++;
        // 왼쪽
        if (iceberg[ice.y][ice.x - 1] == 0)
            count++;
        // 오른쪽
        if (iceberg[ice.y][ice.x + 1] == 0)
            count++;

        return count;
    }

    public static int solve() {
        int year = 1;
        while (!iceList.isEmpty()) {
            for (Ice ice : iceList) {
                ice.iceCount -= surroundSeaCount(ice);
                if (ice.iceCount < 0)
                    ice.iceCount = 0;
            }

            for (Ice ice : iceList) {
                iceberg[ice.y][ice.x] = ice.iceCount;
            }

            iceList.removeIf(ice ->
                    (ice.iceCount == 0)
            );

            boolean isIn = false;
            for (int i = 0; i < iceberg.length && !isIn; i++) {
                for (int j = 0; j < iceberg[0].length; j++) {
                    if (iceberg[i][j] != 0) {
                        isIn = true;
                        if (bfs(j, i))
                            return year;
                        break;
                    }
                }
            }
            year++;
        }

        return 0;
    }

    public static boolean bfs(int x, int y) {
        boolean[][] visited = new boolean[row][column];
        int[][] currentIceberg = new int[row][column];

        for (Ice ice : iceList) {
            currentIceberg[ice.y][ice.x] = ice.iceCount;
        }

        Queue<Ice> q = new LinkedList<>();
        q.add(new Ice(x, y, 0));
        while (!q.isEmpty()) {
            Ice current = q.poll();
            for (int i = 0; i < 4; i++) {
                int dx = current.x + interval[i][0];
                int dy = current.y + interval[i][1];
                if (currentIceberg[dy][dx] != 0 && !visited[dy][dx]) {
                    visited[dy][dx] = true;
                    currentIceberg[dy][dx] = -1;
                    q.add(new Ice(dx, dy, 0));
                }
            }
        }

        boolean isSplited = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (currentIceberg[i][j] > 0) {
                    isSplited = true;
                    break;
                }
            }
        }

        return isSplited;
    }


    static class Ice {
        int x;
        int y;
        int iceCount;
        int group = 0;

        public Ice(int x, int y, int iceCount) {
            this.x = x;
            this.y = y;
            this.iceCount = iceCount;
        }
    }
}
