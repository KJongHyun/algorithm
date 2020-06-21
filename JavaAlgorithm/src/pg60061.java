import java.util.ArrayList;
import java.util.List;

public class pg60061 {
    public static int[][] map;
    public static int mapLength;

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

        int[][] ans = solution(5, buildFrame);
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
        mapLength = n + 1;
        map = new int[mapLength][mapLength];
        for (int i = 0; i < mapLength; i++) {
            for (int j = 0; j < mapLength; j++) {
                map[i][j] = 3;
            }
        }

        for (int i = 0; i < build_frame.length; i++) {
            if (build_frame[i][3] == 1) {
                boolean isBuildable;
                if (build_frame[i][2] == 1)
                    isBuildable = isBuildableBo(build_frame[i][0], build_frame[i][1]);
                else
                    isBuildable = isBuildablePillar(build_frame[i][0], build_frame[i][1]);
                if (isBuildable) {
                    map[build_frame[i][1]][build_frame[i][0]] = build_frame[i][2];
                }
            } else {
                boolean isRemovable;
                if (build_frame[i][2] == 1)
                    isRemovable = isRemovableBo(build_frame[i][0], build_frame[i][1]);
                else
                    isRemovable = isRemovablePillar(build_frame[i][0], build_frame[i][1]);
                if (isRemovable) {
                    map[build_frame[i][1]][build_frame[i][0]] = 3;
                }
            }
        }
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < mapLength; i++) {
            for (int j = 0; j < mapLength; j++) {
                if (map[i][j] != 3) {
                    int[] resultArray = {j, i, map[i][j]};
                    result.add(resultArray);
                }
            }
        }

        int[][] ansArray = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            ansArray[i] = result.get(0);
        }

        return ansArray;
    }

    public static boolean isBuildableBo(int x, int y) {
        // 아래가 기둥인경우
        if (map[y - 1][x] == 0)
            return true;
        // 아래 오른쪽이 기둥인경
        if (x < (mapLength - 1) && map[y - 1][x + 1] == 0)
            return true;
        if ((x - 1 > 0 && x + 1 < mapLength) && (map[y][x + 1] == 1 && map[y][x - 1] == 1))
            return true;

        return false;
    }

    public static boolean isBuildablePillar(int x, int y) {
        if (y == 0)
            return true;
        if (map[y - 1][x] == 0 || (x > 0 && map[y - 1][x - 1] == 1))
            return true;
        return false;
    }

    public static boolean isRemovableBo(int x, int y) {
        return true;
    }

    public static boolean isRemovablePillar(int x, int y) {
        return true;
    }

}
