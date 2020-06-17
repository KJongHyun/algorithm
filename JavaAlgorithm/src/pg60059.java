public class pg60059 {
    public static void main(String[] args) {

        int[][] resultLock = new int[10][10];
    }

    public boolean solution(int[][] key, int[][] lock) {



        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                int[][] result = initLock(lock);
                // 블럭 체크하는 로직;



                if (checkLock(result))
                    return true;
            }
        }

        return false;
    }
    public int[][] rotate90(int[][] key) {
        int[][] rotate90 = new int[key.length][key.length];
        int row = 0;
        for (int i = 0; i < key.length; i++) {
            int col = 0;
            for (int j = key.length - 1; i >= 0; i--) {
                rotate90[row][col++] = key[i][j];
            }
            row++;
        }

        return rotate90;
    }

    public int[][] rotate180(int[][] key) {
        int[][] rotate180 = new int[key.length][key.length];
        int row = 0;
        for (int i = key.length - 1; i >= 0; i--) {
            int col = 0;
            for (int j = key.length - 1; j>= 0; j--) {
                rotate180[row][col++] = key[i][j];
            }
            row++;
        }

        return rotate180;
    }

    public int[][] rotate270(int[][] key) {
        int[][] rotate270 = new int[key.length][key.length];
        int row = 0;
        for (int i = 0; i < key.length; i++) {
            int col = 0;
            for (int j = key.length - 1; j >= 0; j--) {
                rotate270[row][col++] = key[j][i];
            }
        }
        return rotate270;
    }


    public int[][] initLock(int[][] source) {
        int[][] dest = new int[source.length][source.length];
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source.length; j++) {
                dest[i][j] = source[i][j];
            }
        }

        return dest;
    }


    public boolean checkLock(int[][] lock) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock.length; j++) {
                if (lock[i][j] == 0)
                    return false;
            }
        }

        return true;
    }

}
