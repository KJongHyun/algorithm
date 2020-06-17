import java.util.Scanner;

public class boj5373 {
    static final int U = 0;
    static final int D = 1;
    static final int F = 2;
    static final int B = 3;
    static final int L = 4;
    static final int R = 5;
    static final int VERTICAL = 0;
    static final int HORIZONTAL = 1;

    static final int CLOCK_WISE = 0;
    static final int COUNTER_CLOCK_WISE =1;

    static class RotateInfo {
        int side;
        int direction;
        int line;

        public RotateInfo(int side, int direction, int line) {
            this.side = side;
            this.direction = direction;
            this.line = line;
        }
    }
    static String [][][] cube = {
            {
                    {"w", "w", "w"},
                    {"w", "w", "w"},
                    {"w", "w", "w"}
            },
            {
                    {"y", "y", "y"},
                    {"y", "y", "y"},
                    {"y", "y", "y"},
            },
            {
                    {"r", "r", "r"},
                    {"r", "r", "r"},
                    {"r", "r", "r"}
            },
            {
                    {"o", "o", "o"},
                    {"o", "o", "o"},
                    {"o", "o", "o"}
            },
            {
                    {"g", "g", "g"},
                    {"g", "g", "g"},
                    {"g", "g", "g"}
            },
            {
                    {"b", "b", "b"},
                    {"b", "b", "b"},
                    {"b", "b", "b"}
            }

    };

    static RotateInfo[][] adjoin = {
            { new RotateInfo(B, HORIZONTAL, 2), new RotateInfo(R, HORIZONTAL, 0), new RotateInfo(F, HORIZONTAL, 0), new RotateInfo(L, HORIZONTAL, 2) }, // U
            { new RotateInfo(F, HORIZONTAL, 2), new RotateInfo(R, HORIZONTAL, 2), new RotateInfo(B, HORIZONTAL, 0), new RotateInfo(L, HORIZONTAL, 0) }, // D
            { new RotateInfo(U, HORIZONTAL, 2), new RotateInfo(R, VERTICAL, 0), new RotateInfo(D, HORIZONTAL, 0), new RotateInfo(L, VERTICAL, 2) }, // F
            { new RotateInfo(U, HORIZONTAL, 0), new RotateInfo(L, VERTICAL, 0), new RotateInfo(D, HORIZONTAL, 2), new RotateInfo(R, VERTICAL, 2) }, // B
            { new RotateInfo(U, VERTICAL, 0), new RotateInfo(F, VERTICAL, 0), new RotateInfo(D, VERTICAL, 2), new RotateInfo(B, VERTICAL, 2) }, // L
            { new RotateInfo(U, VERTICAL, 2), new RotateInfo(B, VERTICAL, 0), new RotateInfo(D, VERTICAL, 0), new RotateInfo(F, VERTICAL, 2) } // R
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rotateCount = sc.nextInt();

        for (int i = 0; i < rotateCount; i++) {
            cube = getNewCube();
            int rotateWayCount = sc.nextInt();
            for (int j = 0; j < rotateWayCount; j++) {
                String rotateWay = sc.next();
                int side;
                int rotateDirection;
                switch (rotateWay.charAt(0)) {
                    case 'U' : side = U; break;
                    case 'D' : side = D; break;
                    case 'F' : side = F; break;
                    case 'B' : side = B; break;
                    case 'L' : side = L; break;
                    case 'R' : side = R; break;
                    default: side = 99; break;
                }

                if (rotateWay.charAt(1) == '-') {
                    rotateDirection = COUNTER_CLOCK_WISE;
                 } else {
                    rotateDirection = CLOCK_WISE;
                }
                rotate(side, rotateDirection);
                System.out.println("rotateWay = " + rotateWay);
                print();
                System.out.println("=====================");
            }

        }
    }

    public static void rotate(int side, int rotateDirection) {

        // 자신 돌리기
        rotateSelf(side, rotateDirection);
        // 인접 부분 돌리기
        // 반시계 방향
        if (rotateDirection == COUNTER_CLOCK_WISE) {
            String[] temp = getCubeLine(adjoin[side][0]);
            for (int i = 0; i <= 2; i++) {
                setCubeLine(adjoin[side][i], getCubeLine(adjoin[side][i + 1]));
            }
            setCubeLine(adjoin[side][3], temp);
        }
        // 시계 방향
        else {
            String[] temp = getCubeLine(adjoin[side][3]);
            for (int i = 3; i >= 1; i--) {
                setCubeLine(adjoin[side][i], getCubeLine(adjoin[side][i - 1]));
            }
            setCubeLine(adjoin[side][0], temp);
        }
    }

    public static String[] getCubeLine(RotateInfo rotateInfo) {
        String[] cubeLine = new String[3];
        if (rotateInfo.direction == VERTICAL) {
            for (int i = 0; i < 3; i++) {
                cubeLine[i] = cube[rotateInfo.side][i][rotateInfo.line];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                cubeLine[i] = cube[rotateInfo.side][rotateInfo.line][i];
            }
        }

        return cubeLine;
    }

    public static void setCubeLine(RotateInfo rotateInfo,String[] cubeLine) {
        if (rotateInfo.direction == VERTICAL) {
            for (int i = 0; i < 3; i++) {
                cube[rotateInfo.side][i][rotateInfo.line] = cubeLine[i];
            }
        } else {
            for (int i = 0; i < 3; i++) {
                cube[rotateInfo.side][rotateInfo.line][i] = cubeLine[i];
            }
        }
    }

    public static void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[U][i][j]);
            }
            System.out.println();
        }
    }

    public static String[][][] getNewCube() {
        String[][][] cube = {
                {
                        {"w", "w", "w"},
                        {"w", "w", "w"},
                        {"w", "w", "w"}
                },
                {
                        {"y", "y", "y"},
                        {"y", "y", "y"},
                        {"y", "y", "y"},
                },
                {
                        {"r", "r", "r"},
                        {"r", "r", "r"},
                        {"r", "r", "r"}
                },
                {
                        {"o", "o", "o"},
                        {"o", "o", "o"},
                        {"o", "o", "o"}
                },
                {
                        {"g", "g", "g"},
                        {"g", "g", "g"},
                        {"g", "g", "g"}
                },
                {
                        {"b", "b", "b"},
                        {"b", "b", "b"},
                        {"b", "b", "b"}
                }

        };
        return cube;
    }

    public static void rotateSelf(int side, int rotateDirection) {
        String[][] newSide = new String[3][3];

        if (rotateDirection == COUNTER_CLOCK_WISE) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    newSide[i][j] = cube[side][j][2 - i];
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    newSide[i][j] = cube[side][2 - j][i];
                }
            }
        }
        cube[side] = newSide;
    }
}
