import java.util.Stack;

public class Hyper1 {
    static String open = "({[";
    static String close = ")}]";

    public static boolean isValid(String brackets) {
        Stack<String> s = new Stack<>();
        for (int i = 0; i < brackets.length(); i++) {
            String bracket = brackets.substring(i, i + 1);
            if (open.indexOf(bracket) >= 0)
                s.push(bracket);
            else {
                if (s.isEmpty())
                    return false;
                if (close.indexOf(bracket) != open.indexOf(s.pop())) {
                    return false;
                }
            }
        }


        return s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[{(})]"));

    }
}
