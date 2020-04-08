import java.util.Scanner;

public class boj2580 {
    static final int ROW = 9;
    static final int COL = 9;
    static int[][] map = new int[ROW + 1][COL + 1];
    static boolean[][] rowVisited = new boolean[10][10];
    static boolean[][] colVisited = new boolean[10][10];
    static boolean[][][] ttVisited = new boolean[4][4][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int row = 1; row <= ROW; row++) {
            for (int col = 1; col <= COL; col++) {
                map[row][col] = sc.nextInt();
            }
        }
        solved();
//        printRow(5);
//
//        printCol(2);
    }

    public static void solved() {
        // 정사각형 체
        // 행, 열 체크
        // 방문 초기화
        for (int row = 1; row <= ROW; row++) {
            for (int i = 1; i <= COL; i++) {
                if (map[row][i] > 0) {
                    int numb = map[row][i];
                    rowVisited[row][numb] = true;
                }
            }
        }

        for (int col = 1; col <= COL; col++) {
            for (int i = 1; i <= ROW; i++) {
                if (map[i][col] > 0) {
                    int numb = map[i][col];
                    colVisited[col][numb] = true;
                }
            }
        }

        for (int row = 1; row <= ROW; row++) {
            for (int col = 1; col <= COL; col++) {
                if (map[row][col] > 0) {
                    int ttRow = (int) Math.ceil((double) row / 3);
                    int ttCol = (int) Math.ceil((double) col / 3);

                    ttVisited[ttRow][ttCol][map[row][col]] = true;
                }
            }
        }

        sdoku(1, 1);
    }

    public static void sdoku(int cRow, int cCol) {
        if (cRow > 9) {
            printMap();
            System.exit(0);
        }


        int ttRow = (int) Math.ceil((double) cRow / 3);
        int ttCol = (int) Math.ceil((double) cCol / 3);
        if (map[cRow][cCol] == 0) {
            for (int vIndex = 1; vIndex <= 9; vIndex++) {
                if (!rowVisited[cRow][vIndex] && !colVisited[cCol][vIndex] && !ttVisited[ttRow][ttCol][vIndex]) {
                    map[cRow][cCol] = vIndex;
                    rowVisited[cRow][vIndex] = true;
                    colVisited[cCol][vIndex] = true;
                    ttVisited[ttRow][ttCol][vIndex] = true;
                    if (cCol == 9) {
                        sdoku(cRow + 1, 1);
                    } else {
                        sdoku(cRow, cCol + 1);
                    }
                    map[cRow][cCol] = 0;
                    rowVisited[cRow][vIndex] = false;
                    colVisited[cCol][vIndex] = false;
                    ttVisited[ttRow][ttCol][vIndex] = false;
                }
            }
            return;
        }
        if (cCol == 9) {
            sdoku(cRow + 1, 1);
        } else {
            sdoku(cRow, cCol + 1);
        }
    }

    public static void checkRow(boolean[] rowVisited, int currentRow) {
        for (int col = 1; col <= COL; col++) {
            int numb = map[currentRow][col];
            if (numb > 0)
                rowVisited[numb] = true;
        }
    }

    public static void printRow(int row) {
        for (int col = 1; col <= COL; col++) {
            System.out.print(rowVisited[row][col] + " ");
        }
        System.out.println();
    }

    public static void printCol(int col) {
        for (int row = 1; row <= COL; row++) {
            System.out.print(colVisited[col][row] + " ");
        }
        System.out.println();
    }

    public static void printTT(int row, int col) {
        for (int i = 1; i <= 9; i++) {
            System.out.print(ttVisited[row][col][i] + " ");
        }
    }

    public static void printMap() {
        for (int row = 1; row <= ROW; row++) {
            for (int col = 1; col <= COL; col++) {
                System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }
    }
}
