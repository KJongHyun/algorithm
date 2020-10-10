import javafx.util.Pair;


public class Coupang1 {

    public static void main(String[] args) {
        solution(1000000);
    }

    public static int[] solution(int N) {

        Pair<Integer, Integer> pair = new Pair<>(-1, -1);
        for (int i = 2; i < 10; i++) {
            int n = N;
            int multipleValue = 1;
            while(n / i > 0) {
                int d = n % i;
                if (d > 0)
                    multipleValue *= d;
                n = n / i;
            }
            if (n > 0)
                multipleValue *= n;
            if (pair.getKey() <= multipleValue) {
                pair = new Pair<>(multipleValue, i);
            }
            System.out.println(i + " : " + multipleValue);
        }
        int[] result = { pair.getValue(), pair.getKey() };
        return result;


    }


}
