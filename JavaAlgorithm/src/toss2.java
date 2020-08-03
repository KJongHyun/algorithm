import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class toss2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] lotto = input.split(" ");

        System.out.println(checkLotto(lotto));

    }

    public static boolean checkLotto(String[] lotto) {
        // 6개 체크
        if (lotto.length != 6)
            return false;

        // 중복 체크, 숫자 범위 체크
        HashMap<String, Boolean> checkDuplication = new HashMap<>();

        for (int i = 0; i < lotto.length; i++) {
            int numb = Integer.parseInt(lotto[i]);
            if (!(numb >= 1 && numb <= 46))
                return false;
        }

        ArrayList<String> lottoList = new ArrayList<>();
        for (int i = 0; i < lotto.length; i++) {
            if (checkDuplication.containsKey(lotto[i]))
                return false;
            checkDuplication.put(lotto[i], true);
            lottoList.add(lotto[i]);
        }

        Collections.sort(lottoList);
        // 오름차순 체크
        for (int i = 0; i < lotto.length; i++) {
            if (!lotto[i].equals(lottoList.get(i)))
                return false;
        }

        return true;
    }
}
