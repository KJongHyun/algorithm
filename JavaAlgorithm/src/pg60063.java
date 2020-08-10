import java.util.*;

public class pg60063 {
    static int ROW;
    static int COL;
    static int[][] BOARD;
    static int[][][] VISIT;
    static HashMap<Robot, Boolean> VISIT_MAP = new HashMap<>();
    static int[][] moveInterval = {
            //lx,ly,rx,ry
            {0, -1}, // up
            {0, 1}, // down
            {-1, 0}, // left
            {1, 0} // right
    };

    static int[][][] rotateInterval = {

            // 수직
            {
                    {0, 0, -1, -1}, // u시계
                    {0, 0, 1, -1},  // u반시계
                    {1, 1, 0, 0}, // d시계
                    {-1, 1, 0, 0} // d반시계
            },
            // 수평
            {
                    {0, 0, -1, 1}, // l시계
                    {0, 0, -1, -1}, // l반시계
                    {1, -1, 0, 0}, // r시계
                    {1, 1, 0, 0} // r반시계
            }
    };

    public static boolean rotateCheck(Robot robot, int index) {
        int x = 0, y = 0;
        if (robot.isHorizontal == 1) {
            switch (index) {
                case 0:
                    y = robot.getRPoint()[1] + 1;
                    x = robot.getRPoint()[0];
                    break;
                case 1:
                    y = robot.getRPoint()[1] - 1;
                    x = robot.getRPoint()[0];
                    break;
                case 2:
                    y = robot.getLPoint()[1] -1;
                    x = robot.getLPoint()[0];
                    break;
                case 3:
                    y = robot.getLPoint()[1] + 1;
                    x = robot.getLPoint()[0];
                    break;
            }
        } else {
            switch (index) {
                case 0:
                    y = robot.getDPoint()[1];
                    x = robot.getDPoint()[0] - 1;
                    break;
                case 1:
                    y = robot.getDPoint()[1];
                    x = robot.getDPoint()[0] + 1;
                    break;
                case 2:
                    y = robot.getUPoint()[1];
                    x = robot.getUPoint()[0] + 1;
                    break;
                case 3:
                    y = robot.getUPoint()[1];
                    x = robot.getUPoint()[0] - 1;
                    break;
            }
        }

        return !(y < 0 || x < 0 || y > ROW - 1 || x > COL - 1 || BOARD[y][x] == 1);

    }

    public static void main(String[] args) {
        // {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}}
        // {{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}}
        int[][] board = {{0, 0, 0, 0, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 1}, {0, 0, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 1, 1, 0}, {0, 0, 0, 0, 0, 1, 1}, {0, 0, 1, 0, 0, 0, 0}};

        System.out.println(solution(board));
    }

    public static class Robot {
        public int[] p1 = new int[2];
        public int[] p2 = new int[2];
        public int isHorizontal;
        public int time;

        public Robot() {
            p1[0] = 0;
            p1[1] = 0;
            p2[0] = 1;
            p2[1] = 0;
            isHorizontal = 1;
            time = 0;
        }

        public int[] getLPoint() {
            return p1[0] > p2[0] ? p2 : p1;
        }

        public int[] getUPoint() {
            return p1[1] > p2[1] ? p2: p1;
        }

        public int[] getRPoint() {
            return p1[0] > p2[0] ? p1 : p2;
        }

        public int[] getDPoint() {
            return p1[1] > p2[1] ? p1 : p2;
        }

        public Robot(int[] p1, int[] p2, int time, int isHorizontal) {
            this.p1 = p1;
            this.p2 = p2;
            this.time = time;
            this.isHorizontal = isHorizontal;
        }

        public int getChangedHorizontal() {
            return isHorizontal == 0 ? 1 : 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Robot robot = (Robot) o;
            return isHorizontal == robot.isHorizontal &&
                    Arrays.equals(p1, robot.p1) &&
                    Arrays.equals(p2, robot.p2);
        }

        @Override
        public int hashCode() {
            int result = Objects.hash(isHorizontal);
            result = 31 * result + Arrays.hashCode(p1);
            result = 31 * result + Arrays.hashCode(p2);
            return result;
        }
    }

    public static int solution(int[][] board) {
        ROW = board.length;
        COL = board[0].length;
        VISIT = new int[2][ROW][COL];
        BOARD = board;
        int answer = 0;
        Queue<Robot> q = new LinkedList<>();
        Robot robot = new Robot();
        q.add(robot);
        VISIT_MAP.put(robot, true);
        while (!q.isEmpty()) {
            Robot currentRobotInfo = q.poll();
            if ((currentRobotInfo.p1[0] == COL - 1 && currentRobotInfo.p1[1] == ROW - 1) || (currentRobotInfo.p2[0] == COL - 1 && currentRobotInfo.p2[1] == ROW - 1)) {
                return currentRobotInfo.time;
            }
            for (int moveIndex = 0; moveIndex < 4; moveIndex++) {
                int lx = currentRobotInfo.p1[0] + moveInterval[moveIndex][0];
                int ly = currentRobotInfo.p1[1] + moveInterval[moveIndex][1];
                int rx = currentRobotInfo.p2[0] + moveInterval[moveIndex][0];
                int ry = currentRobotInfo.p2[1] + moveInterval[moveIndex][1];
                Robot checkRobot = new Robot(new int[] {lx, ly}, new int[] {rx, ry}, 0, currentRobotInfo.isHorizontal);
                if (checkChange(lx, ly) && checkChange(rx, ry) && !VISIT_MAP.containsKey(checkRobot)) {
                    VISIT_MAP.put(checkRobot, true);
                    Robot newRobot = new Robot(checkRobot.p1, checkRobot.p2, currentRobotInfo.time + 1, currentRobotInfo.isHorizontal);
                    q.add(newRobot);

                }
            }

            for (int rotateIndex = 0; rotateIndex < 4; rotateIndex++) {
                int[] p1;
                int[] p2;
                if (currentRobotInfo.isHorizontal == 1) {
                    p1 = currentRobotInfo.getLPoint();
                    p2 = currentRobotInfo.getRPoint();
                } else {
                    p1 = currentRobotInfo.getUPoint();
                    p2 = currentRobotInfo.getDPoint();
                }
                int p1x = p1[0] + rotateInterval[currentRobotInfo.isHorizontal][rotateIndex][0];
                int p1y = p1[1] + rotateInterval[currentRobotInfo.isHorizontal][rotateIndex][1];
                int p2x = p2[0] + rotateInterval[currentRobotInfo.isHorizontal][rotateIndex][2];
                int p2y = p2[1] + rotateInterval[currentRobotInfo.isHorizontal][rotateIndex][3];
                Robot rotatedRobot = new Robot(new int[] {p1x, p1y}, new int[] {p2x, p2y}, 0, currentRobotInfo.getChangedHorizontal());
                if (rotateCheck(currentRobotInfo, rotateIndex) && checkChange(p1x, p1y) && checkChange(p2x, p2y) && !VISIT_MAP.containsKey(rotatedRobot)) {
                    Robot newRobot = new Robot(new int[] {p1x, p1y}, new int[] {p2x, p2y}, currentRobotInfo.time + 1, rotatedRobot.isHorizontal);
                    VISIT_MAP.put(newRobot, true);
                    q.add(newRobot);
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
