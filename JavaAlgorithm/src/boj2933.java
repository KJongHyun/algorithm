import java.util.*;

public class boj2933 {
    static int ROW;
    static int COL;
    static List<Dot> cluster = new ArrayList<>();
    static int[][] map;
    static int[][] interval = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) {
        /**
         *  1. 입력
         *  행, 열 수 입력 받기
         *  빈칸, 미네랄 입력
         *  막대기 던질 횟수
         *  행 값
         *  2. 미네랄 깨기
         *  3. 방문한것 체크
         *  4. 공중에 떠있는 미네랄 체크
         *  5. 중력 적용
         */

        Scanner sc = new Scanner(System.in);
        ROW = sc.nextInt();
        COL = sc.nextInt();
        map = new int[ROW][COL];
        for (int row = ROW - 1; row >= 0; row--) {
            String line = sc.next();
            for (int col = 0; col < COL; col++) {
                if (line.charAt(col) == 'x')
                    map[row][col] = 1;
                else
                    map[row][col] = 0;
            }
        }

        int stickCount = sc.nextInt();
        for (int count = 0; count < stickCount; count++) {
            int throwRow = sc.nextInt();
            if (count % 2 == 0) {
                throwStick("L", throwRow - 1);
            } else {
                throwStick("R", throwRow - 1);
            }

            boolean[][] visited = new boolean[ROW][COL];
            // 바닥에 붙어 있는 클러스터
            for (int col = 0; col < COL; col++) {
                if (!visited[0][col]) {
                    bfs(0, col, visited);
                }
            }

            for (int row = 0; row < ROW; row++) {
                for (int col = 0; col < COL; col++) {
                    if (map[row][col] == 1 && !visited[row][col]) {
                        cluster.add(new Dot(row, col));
                    }
                }
            }

            if (cluster.size() != 0)
                down();
            cluster.clear();
        }

        printMap(map);
    }

    public static void throwStick(String dir, int throwRow) {
        if (dir.equals("L")) {
            for (int col = 0; col < COL; col++) {
                if (map[throwRow][col] == 1) {
                    map[throwRow][col] = 0;
                    break;
                }
            }
        } else {
            for (int col = COL - 1; col >= 0; col--) {
                if (map[throwRow][col] == 1) {
                    map[throwRow][col] = 0;
                    break;
                }
            }
        }
    }

    public static void printMap(int[][] map) {
        for (int row = ROW - 1; row >= 0; row--) {
            for (int col = 0; col < COL; col++) {
                if (map[row][col] == 1) {
                    System.out.print("x");
                } else if (map[row][col] == 0) {
                    System.out.print(".");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }

    public static void bfs(int row, int col, boolean[][] visited) {
        Queue<Dot> queue = new LinkedList<>();
        queue.add(new Dot(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Dot dot = queue.poll();

            for (int i = 0; i < 4; i++) {
                int dRow = dot.row + interval[i][0];
                int dCol = dot.col + interval[i][1];
                if (dRow >= 0 && dCol >= 0 && dRow < ROW && dCol < COL && map[dRow][dCol] == 1 && !visited[dRow][dCol]) {
                    queue.add(new Dot(dRow, dCol));
                    visited[dRow][dCol] = true;
                }
            }
        }
    }

    public static void down() {
        for(Dot dot : cluster) {
            map[dot.row][dot.col] = 0;
        }

        int min = 9999;
        for (Dot dot : cluster) {
            int count = 1;
            while(true) {
                int temp = count + 1;
                if (dot.row - temp < 0 || map[dot.row - temp][dot.col] == 1)
                    break;
                count++;
            }
            if (min > count)
                min = count;
        }

        for(Dot dot : cluster) {
            map[dot.row - min][dot.col] = 1;
        }
        cluster.clear();
    }

    public static class Dot {
        int row;
        int col;

        Dot(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
