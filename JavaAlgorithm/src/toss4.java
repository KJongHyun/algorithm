import java.io.*;
import java.util.ArrayList;
import java.util.List;

class toss4 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] split = input.split(" ");
        List<String> cache = new ArrayList<>();

        for (String value : split) {
            cache.remove(value);

            if (cache.size() >= 5)
                cache = cache.subList(0, 4);
            cache.add(0, value);

            for (String cacheValue : cache) {
                System.out.print(cacheValue + " ");
            }
            System.out.println();
        }

    }
}