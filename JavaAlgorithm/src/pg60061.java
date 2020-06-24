import java.util.ArrayList;
import java.util.List;

public class pg60061 {
    public static int[][] map;
    public static int mapLength;

    public static int[][][] contructMap;

    public static void main(String[] args) {
        int[][] buildFrame = {
                {1, 0, 0, 1},
                {1, 1, 1, 1},
                {2, 1, 0, 1},
                {2, 2, 1, 1},
                {5, 0, 0, 1},
                {5, 1, 0, 1},
                {4, 2, 1, 1},
                {3, 2, 1, 1}
        };

        int[][] buildFrame2 =
                {{0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0}, {1, 1, 1, 0}, {2, 2, 0, 1}};


        int[][] ans = solution(5, buildFrame2);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(ans[i][j] + " ");
            }

            System.out.println();
        }

    }

//    build_frame의 원소는 [x, y, a, b]형태입니다.
//            x, y는 기둥, 보를 설치 또는 삭제할 교차점의 좌표이며, [가로 좌표, 세로 좌표] 형태입니다.
//    a는 설치 또는 삭제할 구조물의 종류를 나타내며, 0은 기둥, 1은 보를 나타냅니다.
//    b는 구조물을 설치할 지, 혹은 삭제할 지를 나타내며 0은 삭제, 1은 설치를 나타냅니다.
    // 0 = 기둥, 1 = 보
    // 0 = 삭제, 1 = 설

    public static int[][] solution(int n, int[][] build_frame) {
        mapLength = n;
        map = new int[mapLength + 1][mapLength + 1];
        contructMap = new int[2][mapLength + 1][mapLength + 1];
        for (int i = 0; i <= mapLength; i++) {
            for (int j = 0; j <= mapLength; j++) {
                map[i][j] = -1;
                contructMap[0][i][j] = -1;
                contructMap[1][i][j] = -1;

            }
        }

        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];
            // 설치
            if (b == 1) {
                boolean isBuildable;
                if (a == 1)
                    isBuildable = isBuildableBo(x, y);
                else
                    isBuildable = isBuildablePillar(x, y);
                if (isBuildable) {
                    contructMap[a][y][x] = a;
                }
            } else { // 삭제
                boolean isRemovable = true;
                // 해당 블럭을 빼고 현재 상태가 가능한지 체크
                int tempConstruct = a;
                contructMap[a][y][x] = -1;
                for (int removeI = 0; removeI <= mapLength; removeI++) {
                    for (int removeJ = 0; removeJ <= mapLength; removeJ++) {

                        if (contructMap[0][removeI][removeJ] != -1 && !isBuildablePillar(removeJ, removeI)) {
                            isRemovable = false;
                            break;
                        }
                        if (contructMap[1][removeI][removeJ] != -1 && !isBuildableBo(removeJ, removeI)) {
                            isRemovable = false;
                            break;

                        }
                    }
                }

                contructMap[tempConstruct][y][x] = isRemovable ? -1 : tempConstruct;
            }
        }
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i <= mapLength; i++) {
            for (int j = 0; j <= mapLength; j++) {
                if (contructMap[0][j][i] != -1) {
                    int[] resultArray = {i, j, contructMap[0][j][i]};
                    result.add(resultArray);
                }
                if (contructMap[1][j][i] != -1) {
                    int[] resultArray = {i, j, contructMap[1][j][i]};
                    result.add(resultArray);
                }
            }
        }

        int[][] ansArray = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            ansArray[i] = result.get(i);
        }

        return ansArray;
    }

    public static boolean isBuildableBo(int x, int y) {
        // 보를 설치할 수 있는 경우
        // 바로 아래가 기둥인경우
        if (contructMap[0][y - 1][x] == 0)
            return true;
        // 오른쪽 아래가 기둥인경우
        if (contructMap[0][y - 1][x + 1] == 0)
            return true;
        // 양쪽이 보인 경우
        if (x > 0 && contructMap[1][y][x - 1] == 1 && contructMap[1][y][x + 1] == 1)
            return true;
        return false;
    }

    public static boolean isBuildablePillar(int x, int y) {
        // 기둥을 설치할 수 있는경우
        // 바닥인경우
        if (y == 0)
            return true;
        // 아래가 기둥인경우
        if (contructMap[0][y - 1][x] == 0)
            return true;
        // 왼쪽 보가 설치된 경우
        if (x > 0 && contructMap[1][y][x - 1] == 1)
            return true;
        // 겹처서 보가 설치된 경
        if (x > 0 && contructMap[1][y][x] == 1)
            return true;
        return false;
    }

}
