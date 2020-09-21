import java.util.Map;

public class pg67256 {

    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        solution(numbers, "right");
    }

    public static String solution(int[] numbers, String hand) {

        StringBuilder sb = new StringBuilder();
        int currentL = 10;
        int currentR = 12;
        for (int number : numbers) {
            if (number == 1 || number == 4 || number == 7) {
                sb.append("L");
                currentL = getNumber(number);

            } else if (number == 3 || number == 6 || number == 9) {
                sb.append("R");
                currentR = getNumber(number);
            } else {
                Point lp = getPoint(currentL);
                Point rp = getPoint(currentR);
                Point np = getPoint(getNumber(number));
                int lInterval = 0;
                int rInterval = 0;
                lInterval += Math.abs(lp.x - np.x);
                lInterval += Math.abs(lp.y - np.y);
                rInterval += Math.abs(rp.x - np.x);
                rInterval += Math.abs(rp.y - np.y);

                if (lInterval > rInterval) {
                    sb.append("R");
                    currentR = getNumber(number);
                } else if (lInterval < rInterval) {
                    sb.append("L");
                    currentL = getNumber(number);
                } else {
                    if (hand.equals("left")) {
                        sb.append("L");
                        currentL = getNumber(number);
                    } else {
                        sb.append("R");
                        currentR = getNumber(number);
                    }
                }
            }
        }

        return sb.toString();
    }

    private static int getNumber(int number) {
        return number == 0 ? 11 : number;
    }

    private static Point getPoint(int number) {
        int x = number % 3 == 0 ? 3 : number % 3;
        int y = (int) (Math.ceil(number / 3.0));
        return new Point(x, y);
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
