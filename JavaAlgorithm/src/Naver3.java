public class Naver3 {
    static int[] matchCount = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    static long count = 0;
    static int[] dp = new int[500];

    public static void main(String[] args) {

        int[] need = { 6,2,5,5,4,5,6,3,7,6 };
        int k;
        long[] DP = new long[51];
        DP[0] = DP[1] = 0;
        DP[2] = 1;
        DP[3] = 1;
        DP[4] = 2;
        DP[5] = 5;
        DP[6] = 7;
        DP[7] = 12;
        for (int i = 8; i <= 50; i++) {
            for (int j = 0; j < 10; j++)
                DP[i] += DP[i - need[j]];

            System.out.println(i + " " + (DP[i] - DP[i - need[0]]));
        }
    }

    public static void dfs(int currentMatchCount, int depth) {
        if (currentMatchCount == 0) {
            count++;
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (currentMatchCount >= matchCount[i]) {
                if (depth == 0 && i == 0) {
                    if (currentMatchCount == 6)
                        count++;
                    continue;
                }
                dfs(currentMatchCount - matchCount[i], depth + 1);
            }
        }
    }

    //dp[num] = dp[num - 6] * 3 + dp[num - 2] + dp[num -5] * 3 + dp[num -4] + dp[num - 3] + dp[num - 7] 이거 맞나요?

    public static int dp(int num) {
        if (dp[num] != 0)
            return dp[num];
        if (num == 0 || num == 9) {
            return dp[0] = dp[9] = 6;
        } else if (num == 1) {
            return dp[1] = 2;
        } else if (num == 2 || num == 3 || num == 5) {
            return dp[2] = dp[3] = dp[5] = 5;
        } else if (num == 4) {
            return dp[4] = 4;
        } else if (num == 6 || num == 9) {
            return dp[6] = dp[9] = 6;
        } else if (num == 7) {
            return dp[7] = 3;
        } else if (num == 8) {
            return dp[8] = 7;
        } else {
            return dp[num] = dp[num - 6] * 3 + dp[num - 2] + dp[num - 5] * 3 + dp[num - 4] + dp[num - 3] + dp[num - 7];
        }
    }
}


