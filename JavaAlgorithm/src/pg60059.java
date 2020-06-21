public class pg60059 {
    public static void main(String[] args) {

        int[][] resultLock = new int[10][10];
        int[][] lock = {
                {1, 1, 1},
                {1, 0, 0},
                {1, 0, 1}
        };

        int[][] key = {
                {0, 0, 0},
                {1, 0, 0},
                {0, 1, 1}
        };

        if (solution(key, lock))
            System.out.println("풀림");
        else
            System.out.println("안풀림");
    }

    public static boolean solution(int[][] key, int[][] lock) {

        int paddingLockLength = lock.length + (key.length - 1) * 2;

        int[][][] rotatekeySet = new int[4][key.length][key.length];
        rotatekeySet[0] = key;
        rotatekeySet[1] = rotate90(key);
        rotatekeySet[2] = rotate180(key);
        rotatekeySet[3] = rotate270(key);


        for (int outsideI = 0; outsideI <= paddingLockLength - key.length; outsideI++) {
            for (int outsideJ = 0; outsideJ <= paddingLockLength - key.length; outsideJ++) {
                for (int rotate = 0; rotate < 4; rotate++) {
                    int[][] paddingLock = initPaddingLock(key, lock);
                    boolean isCrash = false;
                    for (int i = 0; i < key.length; i++) {
                        for (int j = 0; j < key.length; j++) {
                            if (paddingLock[i + outsideI][j + outsideJ] == 1 && rotatekeySet[rotate][i][j] == 1) {
                                isCrash = true;
                                break;
                            }
                            if(rotatekeySet[rotate][i][j] == 1)
                                paddingLock[i + outsideI][j + outsideJ] = rotatekeySet[rotate][i][j];
                        }

                        if (isCrash)
                            break;
                    }
                    if (!isCrash) {
                        // 다꽂아졌는지 체크
                        boolean isFull = true;
                        for (int i = 0; i < lock.length; i++) {
                            for (int j = 0; j < lock.length; j++) {
                                if(paddingLock[i + key.length - 1][j + key.length - 1] == 0) {
                                    isFull = false;
                                    break;
                                }
                            }
                            if (!isFull)
                                break;
                        }

                        if (isFull) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public static int[][] initPaddingLock(int[][] key, int[][] lock) {
        // init padding lock
        int paddingLockLength = lock.length + (key.length - 1) * 2;
        int[][] paddingLock = new int[paddingLockLength][paddingLockLength];

        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                paddingLock[i + key.length - 1][j + key.length - 1] = lock[i][j];
            }
        }

        return paddingLock;
    }


    public static int[][] rotate90(int[][] key) {
        int[][] rotate90 = new int[key.length][key.length];
        int row = 0;
        for (int i = 0; i < key.length; i++) {
            int col = 0;
            for (int j = key.length - 1; j >= 0; j--) {
                rotate90[row][col++] = key[j][i];
            }
            row++;
        }

        return rotate90;
    }

    public static int[][] rotate180(int[][] key) {
        int[][] rotate180 = new int[key.length][key.length];
        int row = 0;
        for (int i = key.length - 1; i >= 0; i--) {
            int col = 0;
            for (int j = key.length - 1; j >= 0; j--) {
                rotate180[row][col++] = key[i][j];
            }
            row++;
        }

        return rotate180;
    }

    public static int[][] rotate270(int[][] key) {
        int[][] rotate270 = new int[key.length][key.length];
        int row = 0;
        for (int i = key.length - 1; i >= 0; i--) {
            int col = 0;
            for (int j = 0; j < key.length; j++) {
                rotate270[row][col++] = key[j][i];
            }
            row++;
        }
        return rotate270;
    }
}
