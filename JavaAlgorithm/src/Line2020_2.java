import java.util.*;

public class Line2020_2 {
    public static void main(String[] args) {
        int[] ball = {11, 2, 9, 13, 24};
        int[] order = {9, 2, 13, 24, 11};
        solution(ball, order);
    }

    public static int[] solution(int[] ball, int[] order) {
        List<Integer> answer = new ArrayList<>();

        Deque<Integer> ballList = new ArrayDeque<>();
        Queue<Integer> orderList = new LinkedList<>();
        List<Integer> postpone = new ArrayList<>();
        for (Integer ballValue : ball) {
            ballList.add(ballValue);
        }

        for (Integer orderValue : order) {
            orderList.add(orderValue);
        }


        for (Integer orderValue : order) {
            checkPostpone(answer, ballList, postpone);

            if (ballList.peekFirst() == orderValue) {
                answer.add(ballList.removeFirst());
                orderList.poll();
            } else if (ballList.peekLast() == orderValue) {
                answer.add(ballList.removeLast());
                orderList.poll();
            } else {
                postpone.add(orderValue);
                orderList.poll();
            }
        }


        int[] arrAnswer = new int[answer.size()];

        for (int i = 0; i < answer.size(); i++) {
            arrAnswer[i] = answer.get(i);
        }

        return arrAnswer;
    }

    private static void checkPostpone(List<Integer> answer, Deque<Integer> ballList, List<Integer> postpone) {
        for (Integer postponeValue : postpone) {
            boolean isRemove = false;
            if (ballList.peekFirst() == postponeValue) {
                answer.add(ballList.removeFirst());
                isRemove = true;
            } else if (ballList.peekLast() == postponeValue) {
                answer.add(ballList.removeLast());
                isRemove = true;
            }

            if (isRemove) {
                checkPostpone(answer, ballList, postpone);
            }
        }
    }
}
