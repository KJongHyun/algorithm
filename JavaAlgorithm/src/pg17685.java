import java.util.HashMap;
import java.util.Map;

public class pg17685 {

    public static void main(String[] args) {
        String[] arr = {
                "word", "war", "warrior", "world"
        };
        System.out.println(solution(arr));
    }

    public static int solution(String[] words) {
        int ans = 0;
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        for (String word : words) {
            int count = trie.getCount(word);
            ans += count;
        }

        return ans;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        void insert(String word) {
            TrieNode currentNode = root;
            for (int i = 0; i < word.length(); i++) {
                String target = String.valueOf(word.charAt(i));
                if (currentNode.children.containsKey(target)) {
                    currentNode = currentNode.children.get(target);
                    currentNode.possibleWord++;
                } else {
                    currentNode.children.put(target, new TrieNode());
                    currentNode = currentNode.children.get(target);
                }
            }
        }

        int getCount(String word) {
            TrieNode currentNode = root;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                String target = String.valueOf(word.charAt(i));
                sb.append(target);
                if (currentNode.children.containsKey(target) && currentNode.children.get(target).possibleWord == 1) {
                    return sb.length();
                }
                currentNode = currentNode.children.get(target);
            }
            return sb.length();
        }
    }

    static class TrieNode {
        int possibleWord = 1;
        Map<String, TrieNode> children = new HashMap<>();
    }

}
