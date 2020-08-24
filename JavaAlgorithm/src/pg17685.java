import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class pg17685 {

    public static void main(String[] args) {
        String[] arr = {
                "word", "war", "warrior", "world"
        };
        System.out.println(solution(arr));
    }

//    public static int solution(String[] words) {
//
//        List<String> wordsList = new ArrayList<>();
//
//        for (String word : words) {
//            wordsList.add(word);
//        }
//
//        Map<String, String> cache = new HashMap<>();
//
//        int typeCount = 0;
//
//        for (String targetWord : words) {
//
//            String startWord = cache.get(targetWord);
//            int startIndex = startWord == null ? 1 : startWord.length();
//            for (int i = startIndex; i <= targetWord.length(); i++) {
//                String typeWord = targetWord.substring(0, i);
//                List<String> collectList = wordsList.stream().filter(word ->
//                        word.startsWith(typeWord)).collect(Collectors.toList());
//
//                for (String collectWord : collectList) {
//                    if (cache.containsKey(collectWord)) {
//                        String preTypeWord = cache.get(collectWord);
//                        if (preTypeWord.length() < typeWord.length())
//                            cache.put(collectWord, typeWord);
//                    } else {
//                        cache.put(collectWord, typeWord);
//                    }
//                }
//                if (collectList.size() == 1 || typeWord.equals(targetWord)) {
//                    typeCount += typeWord.length();
//                    break;
//                }
//            }
//        }
//        return typeCount;
//    }

    public static int solution(String[] words) {

        List<String> wordsList = new ArrayList<>();

        for (String word : words) {
            wordsList.add(word);
        }

        Map<String, String> cache = new HashMap<>();
        Map<String, List<String>> searchCache = new HashMap<>();


        int typeCount = 0;

        for (String targetWord : words) {

            String startWord = cache.get(targetWord);
            int startIndex = startWord == null ? 1 : startWord.length();
            List<String> searchList = wordsList;
            for (int i = startIndex; i <= targetWord.length(); i++) {
                String typeWord = targetWord.substring(0, i);
                List<String> collectList = searchCache.get(typeWord);
                if (collectList == null) {
                    searchList = searchList.stream().filter(word ->
                            word.startsWith(typeWord)).collect(Collectors.toList());
                    searchCache.put(typeWord, searchList);
                    for (String collectWord : searchList) {
                        if (cache.containsKey(collectWord)) {
                            String preTypeWord = cache.get(collectWord);
                            if (preTypeWord.length() < typeWord.length())
                                cache.put(collectWord, typeWord);
                        } else {
                            cache.put(collectWord, typeWord);
                        }
                    }
                }


                if (searchList.size() == 1 || typeWord.equals(targetWord)) {
                    typeCount += typeWord.length();
                    break;
                }
            }
        }

        return typeCount;

    }

}
