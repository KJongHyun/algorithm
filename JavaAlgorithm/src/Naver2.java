public class Naver2 {

    static boolean[] visited;
    static int[][] sEdges;
    public static void main(String[] args) {

    }

    public int[] solution(int n, int[][] edges) {
        int[] answer = {};
        sEdges = edges;
        visited = new boolean[edges.length];

        return answer;
    }

    public static void backtrack(int depth) {
        if (depth == 2) {

            return;
        }

        for (int i = depth; i < sEdges.length; i++) {
            int[] coordinate = sEdges[i];
            backtrack(depth + 1);
        }
    }
}
