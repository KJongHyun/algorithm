import java.util.Arrays;
import java.util.List;

public class KakaoEnter1 {

    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(-3, -2, 10, 20, -30);
        System.out.println(splitIntoTwo(integers));
    }

    public static int splitIntoTwo(List<Integer> arr) {
        int matchCount = 0;
        int amount = sumList(arr);
        int leftSum = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            leftSum += arr.get(i);
            amount -= arr.get(i);
            if (leftSum > amount)
                matchCount++;
        }

        return matchCount;
    }

    public static int sumList(List<Integer> arr) {
        int sum = 0;
        for (Integer e : arr) {
            sum += e;
        }

        return sum;
    }
}
