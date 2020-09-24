import java.util.LinkedList;
import java.util.Stack;

public class pg183744 {

    public static void main(String[] args) {
        System.out.println(solution("()()"));
    }

    public static boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();


        boolean ans = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(-1);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if (stack.isEmpty()) {
            ans = true;
        }

        return ans;
    }

}
