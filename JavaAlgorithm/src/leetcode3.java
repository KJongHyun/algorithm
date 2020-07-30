import java.util.HashMap;


public class leetcode3 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                if (count > max) {
                    max = count;
                }
                count = 0;
                i = map.get(c);
                map.clear();
                continue;
            }
            map.put(c, i);
            count++;
        }

        if (count > max) {
            max = count;
        }
        return max;
    }
}
