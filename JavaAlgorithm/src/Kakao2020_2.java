import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Kakao2020_2 {
    static TreeMap<String, Integer> treeMap = new TreeMap<>();
    public static void main(String[] args) {
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        String[] answer = solution(orders, course);
    }

    public static String[] solution(String[] orders, int[] course) {
        for (int courseCount : course) {
            for (String order : orders) {
                order = stringSort(order);
                combination(courseCount, 0, 0, order, "");
            }
        }
        List<String> answer = new ArrayList<>();

        List<Integer> maxList = new ArrayList<>();

        for (int courseCount : course) {
            AtomicInteger max = new AtomicInteger();
            treeMap.forEach((key, value) -> {
                if (key.length() == courseCount) {
                    if (treeMap.get(key) > 1) {
                        if (max.get() < value) {
                            max.set(value);
                        }
                    }
                }
            });
            maxList.add(max.intValue());
        }

        int index = 0;
        for (int courseCount : course) {
            int targetMax = maxList.get(index++);
            treeMap.forEach((key, value) -> {
                if (key.length() == courseCount && value == targetMax) {
                    answer.add(key);
                }
            });
        }

        Collections.sort(answer);

        return answer.toArray(new String[answer.size()]);
    }

    public static void combination(int length, int depth, int key, String target, String currentMenu) {
        if (depth == length) {
            if (treeMap.containsKey(currentMenu)) {
                treeMap.put(currentMenu, treeMap.get(currentMenu) + 1);
            } else {
                treeMap.put(currentMenu, 1);
            }
        }

        for (int i = key; i < target.length(); i++) {
            StringBuilder sb = new StringBuilder(currentMenu);
            sb.append(target.charAt(i));
            combination(length, depth + 1, i + 1, target, sb.toString());
        }
    }

    public static String stringSort(String target) {
        String[] array = target.split("");
        Arrays.sort(array);
        return String.join("", array);
    }

}
