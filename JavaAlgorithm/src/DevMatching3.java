public class DevMatching3 {
    static boolean[] visit;
    static boolean[] groupVisit;
    static int min = Integer.MAX_VALUE;
    static int N;

    public static void main(String[] args) {
        int n = 7;
        int[][] groups = {{6, 7},{1, 4},{2, 4}};
        System.out.println(solution(n, groups));
    }

    public static int solution(int n, int[][] groups) {
        visit = new boolean[n + 1];
        groupVisit = new boolean[groups.length];
        N = n;
        solve(0, groups, 0);
        return min;
    }

    public static void solve(int depth, int[][] groups, int count) {
        if (depth == groups.length) {
            for (int i = 0; i < groups.length; i++) {
                if (groupVisit[i]) {
                    for (int j = groups[i][0]; j <= groups[i][1]; j++) {
                        visit[j] = true;
                    }
                }
            }
            for (int i = 1; i <= N; i++) {
                if (!visit[i]) {
                    count++;
                }
            }

            if (min > count)
                min = count;

            visit = new boolean[N + 1];
            return;
        }

        groupVisit[depth] = true;
        solve(depth + 1, groups, count + 1);
        groupVisit[depth] = false;
        solve(depth + 1, groups, count);



    }
}
