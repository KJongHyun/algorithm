import java.util.LinkedList;
import java.util.Queue;

public class Kakao2020_6 {
    static int[][] BOARD;
    static int[][] direction = {
            // x y
            {1, 0}, // R
            {0, 1}, // D
            {-1, 0}, // L
            {0, -1} // U
    };

    public static void main(String[] args) {

    }

    public int solution(int[][] board, int r, int c) {
        BOARD = board;
        int answer = 0;
        Queue<GameInfo> q = new LinkedList<>();

        boolean[][][] visited = new boolean[2][4][4];
        visited[0][r][c] = true;
        visited[1][r][c] = true;
        GameInfo gameInfo = new GameInfo(c, r, 0, visited);
        if (BOARD[r][c] != 0) {
            gameInfo.isSelect = true;
            gameInfo.target = BOARD[r][c];
        }

        q.add(gameInfo);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (BOARD[i][j] != 0) {
                    bfsStart(gameInfo, j, i);
                    // bfsTarget(gameInfo, gameInfo.target);
                }
            }
        }

        while (!q.isEmpty()) {
            GameInfo currentGameInfo = q.poll();
            if (isGameCorrect(currentGameInfo.visited)) {
                return currentGameInfo.count;
            }

            if (!currentGameInfo.isSelect) {
                // 시작 지점 찾기
//                bfsStart(currentGameInfo);
            } else {
                // 도착 지점 찾기

            }

//            if (isGameCorrect(currentGameInfo.visited)) {
//                return currentGameInfo.count;
//            }
//
//            int[][] movedArray = new int[2][2];
//            for (int i = 0; i < 4; i++) {
//                movedArray[0][0] = currentGameInfo.cursorX + direction[i][0];
//                movedArray[0][1] = currentGameInfo.cursorY + direction[i][1];
//                movedArray[1][0] = ctrlDirectionX(currentGameInfo.cursorX, currentGameInfo.cursorY, direction[i][0]);
//                movedArray[1][1] = ctrlDirectionY(currentGameInfo.cursorX, currentGameInfo.cursorY, direction[i][1]);
//
//                // 선택
//                // 깨기
//                //
//                for (int j = 0; j < 2; j++) {
//                    if (!visited[j][movedArray[j][0]][movedArray[j][1]]) {
//                        q.add(new GameInfo(currentGameInfo.cursorX + movedArray[j][0], currentGameInfo.cursorY + movedArray[j][1], currentGameInfo.count + 1));
//                        visited[j][movedArray[j][0]][movedArray[j][1]] = true;
//                    }
//                }
//            }
        }



        return answer;
    }

    public static GameInfo bfsStart(GameInfo gameInfo, int x, int y) {
        GameInfo answer = null;
        Queue<GameInfo> q = new LinkedList<>();
        q.add(gameInfo);
        while(!q.isEmpty()) {
            GameInfo currentGameInfo = q.poll();
            if (currentGameInfo.cursorX == x && currentGameInfo.cursorY == y) {
                currentGameInfo.isSelect = true;
                currentGameInfo.target = BOARD[currentGameInfo.cursorY][currentGameInfo.cursorX];
                answer = currentGameInfo;
                break;
            }

            int[][] movedArray = new int[2][2];
            for (int i = 0; i < 4; i++) {
                movedArray[0][0] = currentGameInfo.cursorX + direction[i][0];
                movedArray[0][1] = currentGameInfo.cursorY + direction[i][1];
                movedArray[1][0] = ctrlDirectionX(currentGameInfo.cursorX, currentGameInfo.cursorY, direction[i][0]);
                movedArray[1][1] = ctrlDirectionY(currentGameInfo.cursorX, currentGameInfo.cursorY, direction[i][1]);

                for (int j = 0; j < 2; j++) {

                }
            }

        }

        return answer;
    }

//    public static GameInfo bfsTarget(GameInfo gameInfo, int target) {
//
//    }

    public static int ctrlDirectionX(int x, int y, int move) {
        int dx = x;
        while(true) {
            dx += move;
            if (BOARD[y][dx] != 0 || (dx == 3))
                return dx;
        }
    }

    public static int ctrlDirectionY(int x, int y, int move) {
        int dy = x;
        while(true) {
            dy += move;
            if (BOARD[dy][x] != 0 || (dy == 3))
                return dy;
        }
    }

    public boolean isGameCorrect(boolean[][][] visited) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (BOARD[i][j] != 0 && !visited[0][i][j] && !visited[1][i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static class GameInfo {
        int cursorX;
        int cursorY;
        boolean isSelect;
        boolean[][][] visited;
        int target;
        int count;

        public GameInfo(int cursorX, int cursorY, int count, boolean[][][] visited) {
            this.cursorX = cursorX;
            this.cursorY = cursorY;
            this.count = count;
            this.visited = visited;
        }
    }



}
