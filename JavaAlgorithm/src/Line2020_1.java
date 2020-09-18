public class Line2020_1 {
    public static void main(String[] args) {
        int[][] boxes = {
                {1, 2},
                {2, 1},
                {3, 3},
                {4, 5},
                {5, 6},
                {7, 8}
        };

        System.out.println(solution(boxes));
    }

    public static int solution(int[][] boxes) {
        int count = 0;
        for (int i = 0; i < boxes.length; i++) {
            if (boxes[i][0] ==  boxes[i][1])
                continue;
            boolean coupling = false;
            for (int j = i + 1; j < boxes.length; j++) {
                for (int k = 0; k < 2; k++) {
                    if (boxes[i][k] == boxes[j][0]) {
                        int temp = boxes[i][k];
                        boxes[i][k] = boxes[j][1];
                        boxes[j][1] = temp;
                    } else if (boxes[i][k] == boxes[j][1]) {
                        int temp = boxes[i][k];
                        boxes[i][k] = boxes[j][0];
                        boxes[j][0] = temp;
                    }

                    if (boxes[i][0] == boxes[i][1] && boxes[j][0] == boxes[j][1])
                        coupling = true;
                }
            }

            if (!coupling)
                count++;
        }
        return count;
    }
}
