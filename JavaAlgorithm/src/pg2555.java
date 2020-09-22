public class pg2555 {

    static boolean[] visited = new boolean[20];
    static int count = 0;
    static int[] numberArr;
    static int sTarget;
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        System.out.println(solution(numbers, 3));
    }

    public static int solution(int[] numbers, int target) {
        numberArr = numbers;
        sTarget = target;
        backTrack(0);
        return count;
    }

    public static void backTrack(int depth) {
        if (depth == numberArr.length) {
            int sum = 0;
            for (int i = 0; i < numberArr.length; i++) {
                int oper = visited[i] ? -1 : 1;
                sum += (numberArr[i] * oper);
            }

            if (sum == sTarget)
                count++;
            return;
        }

        visited[depth] = true;
        backTrack(depth  + 1);
        visited[depth] = false;
        backTrack(depth + 1);
    }

}
