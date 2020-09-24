import java.util.LinkedList;
import java.util.Queue;

public class pg67259 {

    static int[][] d;
    static int INF = 100000000;
    static int[][] gameBoard;
    static int[][] interval = {
            {0 ,1},
            {0, -1},
            {1, 0},
            {-1, 0}
    };

    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 1, 0, 1, 0, 1},
                {0, 1, 0, 0, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 1, 0}
        };
        solution(board);
    }

    public static int solution(int[][] board) {
        gameBoard = board;
        d = new int[gameBoard.length][gameBoard.length];
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard.length; j++) {
                d[i][j] = INF;
            }
        }

        dijkstra();

        return d[gameBoard.length - 1][gameBoard.length - 1];
    }

    public static void dijkstra() {
        d[0][0] = 0;
        Queue<Point> q = new LinkedList<>();
        Point start = new Point(0, 0, -1);
        start.cost = 0;
        q.offer(start);

        while (!q.isEmpty()) {
            Point current = q.poll();
            if (d[current.y][current.x] < current.cost )
                continue;

            for (int i = 0; i < 4; i++) {
                int dx = current.x + interval[i][0];
                int dy = current.y + interval[i][1];
                if (dx >= 0 && dx < gameBoard.length & dy >= 0 && dy < gameBoard.length && gameBoard[dx][dy] == 0) {
                    int cost = current.direction == -1 || current.direction == i ? 100 : 600;
                    Point next = new Point(dx, dy, i);
                    int nextCost = current.cost + cost;
                    if (d[dy][dx] >= nextCost) {
                        d[dy][dx] = nextCost;
                        next.cost = nextCost;
                        q.offer(next);
                    }
                }
            }
        }
    }

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int cost;
        int direction;

        public Point(int x, int y, int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }


        @Override
        public int compareTo(Point o) {
            return this.cost >= o.cost ? 1 : -1;
        }
    }

}
