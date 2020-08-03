//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.function.Function;
//
//public class toss3 {
//    public static void main(String[] args) throws Exception {
//        // [!!주의!!] Function.compute 함수는 이미 구현되어있지만, 숨김처리되어 있습니다. 호출해서 테스트 해주세요.
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        String[] split = input.split(" ");
//        HashMap<Integer, Integer> cache = new HashMap<>();
//        int[] intArray = new int[split.length];
//        for (int i = 0; i < split.length; i++) {
//            intArray[i] = Integer.parseInt(split[i]);
//        }
//
//        List<Integer> ansList = new ArrayList<>();
//        for (int i = 0; i < intArray.length; i++) {
//            if (cache.containsKey(intArray[i])) {
//                ansList.add(cache.get(intArray[i]));
//                continue;
//            }
//            Integer computValue = Function.compute(intArray[i]);
//            cache.put(intArray[i], computValue);
//            ansList.add(computValue);
//        }
//
//        for (Integer value : ansList) {
//            System.out.print(value + " ");
//        }
//    }
//
//    public static void solution(String input) {
//        String[] split = input.split(" ");
//        HashMap<Integer, Integer> cache = new HashMap<>();
//        int[] intArray = new int[split.length];
//        for (int i = 0; i < split.length; i++) {
//            intArray[i] = Integer.parseInt(split[i]);
//        }
//
//        List<Integer> ansList = new ArrayList<>();
//        for (int i = 0; i < intArray.length; i++) {
//            if (cache.containsKey(intArray[i])) {
//                ansList.add(cache.get(intArray[i]));
//                continue;
//            }
//            Integer computValue = Function.compute(intArray[i]);
//            cache.put(intArray[i], computValue);
//            ansList.add(computValue);
//        }
//    }
//}
