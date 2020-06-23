import java.util.Stack;

public class pg60058 {
    public static void main(String[] args) {
        String p = ")()))(((";
        String answer = solution(p);
        System.out.println(answer);
    }

    public static String solution(String p) {
        String answer = rec(p);
        return answer;
    }

    public static String rec(String p) {
        if (p.isEmpty())
            return "";
        int open = 0;
        int close = 0;
        int index = 0;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '(')
                open++;
            else
                close++;
            if (open == close) {
                index = i;
                break;
            }
        }
        String u = p.substring(0, index + 1);
        String v;
        if (index + 1 >= p.length()) {
            v = "";
        } else {
            v = p.substring(index + 1);
        }

        // u가 올바른 괄호인지 체크
        Stack stack = new Stack();
        boolean isComplete = true;
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == '(') {
                stack.push(1);
            } else {
                if (stack.empty()) {
                    isComplete = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }

        if (isComplete) {
            return u + rec(v);
        } else {
            String recP = rec(v);
            StringBuilder sb = new StringBuilder(u);
            sb.deleteCharAt(0);
            sb.deleteCharAt(sb.length() - 1);
            String eraseP = sb.toString();
            StringBuilder stringBuilder = new StringBuilder(eraseP);
            if (!stringBuilder.toString().equals("")) {
                for (int i = 0; i < stringBuilder.length(); i++) {
                    stringBuilder.setCharAt(i, reverseBracket(stringBuilder.charAt(i)));
                }
            }
            String finalString = "(" + recP + ")" + stringBuilder.toString();
            return finalString;
        }

    }

    public static char reverseBracket(char bracket) {
        return (bracket == '(') ? ')' : '(';
    }
}
