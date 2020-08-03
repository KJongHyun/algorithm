import java.util.LinkedList;
import java.util.Queue;

public class pg60063 {
    static int ROW;
    static int COL;
    static int[][] BOARD;
    static int[][][] VISIT;
    static int[][] moveInterval = {
            //lx,ly,rx,ry
            {0, -1},
            {0, 1},
            {-1, 0},
            {1, 0}
    };

    static int[][][] rotateInterval = {
            {
                    {1, -1, 0, 0}, // lUp
                    {1, 1, 0, 0}, // lDown
                    {0, 0, -1, -1}, // rUp
                    {0, 0, -1, 1}  // rDown
            },
            {
                    {1, 1, 0, 0}, // lUp
                    {1, -1, 0, 0}, // lDown
                    {0, 0, -1, 1}, // rUp
                    {0, 0, -1, -1}  // rDown
            }
    };

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }

    public static class Robot {
        public int lx;
        public int ly;
        public int rx;
        public int ry;
        public int isHorizontal;
        public int time;

        public Robot() {
            this.lx = 0;
            this.ly = 0;
            this.rx = 1;
            this.ry = 0;
            this.time = 0;
            this.isHorizontal = 1;
        }

        public Robot(int lx, int ly, int rx, int ry, int time, int isHorizontal) {
            this.lx = lx;
            this.ly = ly;
            this.rx = rx;
            this.ry = ry;
            this.time = time;
            this.isHorizontal = isHorizontal;
        }

        public int getChangedHorizontal() {
            return isHorizontal == 0 ? 1 : 0;
        }
    }

    public static int solution(int[][] board) {
        ROW = board.length;
        COL = board[0].length;
        VISIT = new int[2][ROW][COL];
        BOARD = board;
        int answer = 0;
        Queue<Robot> q = new LinkedList<>();
        q.add(new Robot());
        VISIT[1][0][0] = 1;
        VISIT[1][0][1] = 1;
        while (!q.isEmpty()) {
            Robot currentRobotInfo = q.poll();
            if ((currentRobotInfo.lx == COL && currentRobotInfo.ly == ROW) || (currentRobotInfo.rx == COL && currentRobotInfo.ry == ROW)) {
                return currentRobotInfo.time;
            }
            for (int moveIndex = 0; moveIndex < 4; moveIndex++) {
                int lx = currentRobotInfo.lx + moveInterval[moveIndex][0];
                int ly = currentRobotInfo.ly + moveInterval[moveIndex][1];
                int rx = currentRobotInfo.rx + moveInterval[moveIndex][0];
                int ry = currentRobotInfo.ry + moveInterval[moveIndex][1];
                if (checkChange(lx, ly) && VISIT[currentRobotInfo.isHorizontal][currentRobotInfo.ly][currentRobotInfo.lx] == 0 && checkChange(rx, ry) && VISIT[currentRobotInfo.isHorizontal][currentRobotInfo.ry][currentRobotInfo.rx] == 0) {
                    q.add(new Robot(lx, ly, rx, ry, currentRobotInfo.time + 1, currentRobotInfo.isHorizontal));
                    VISIT[currentRobotInfo.isHorizontal][currentRobotInfo.ry][currentRobotInfo.rx] = 1;
                    VISIT[currentRobotInfo.isHorizontal][currentRobotInfo.ly][currentRobotInfo.lx] = 1;
                }
            }

            for (int rotateIndex = 0; rotateIndex < 4; rotateIndex++) {
                int lx = currentRobotInfo.lx + rotateInterval[currentRobotInfo.isHorizontal][rotateIndex][0];
                int ly = currentRobotInfo.ly + rotateInterval[currentRobotInfo.isHorizontal][rotateIndex][1];
                int rx = currentRobotInfo.rx + rotateInterval[currentRobotInfo.isHorizontal][rotateIndex][2];
                int ry = currentRobotInfo.ry + rotateInterval[currentRobotInfo.isHorizontal][rotateIndex][3];
                if (checkChange(lx, ly) && checkChange(rx, ry)) {
                    q.add(new Robot(lx, ly, rx, ry, currentRobotInfo.time + 1, currentRobotInfo.getChangedHorizontal()));
                }
            }
        }
        return answer;
    }

    public static boolean checkChange(int x, int y) {
        if (x < 0 || y < 0 || x > COL - 1 || y > ROW - 1 || BOARD[y][x] == 1)
            return  false;
        return true;
    }
}
