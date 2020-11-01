public class KakaoHairShop1 {

    public static void main(String[] args) {
        int[][] office = {{1,0,0,0},{0,0,0,1},{0,0,1,0},{0,1,1,0}};
        int[][] office2 = {{1,0,0},{0,0,1},{1,0,0}};
        int k = 2;
        System.out.println(solution(office2, k));
    }

    public static int solution(int[][] office, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < office.length - (k - 1); i++) {
            for (int j = 0; j < office.length - (k - 1); j++) {
                int warmAreaCount = getWarmAreaCount(office, j, i, k);
                if (max < warmAreaCount)
                    max = warmAreaCount;
            }
        }
        return max;
    }

    public static int getWarmAreaCount(int[][] office, int x, int y, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (office[y + i][x + j] == 1)
                    sum++;
            }
        }

        return sum;
    }

}
