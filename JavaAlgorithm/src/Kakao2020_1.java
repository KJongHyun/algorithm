public class Kakao2020_1 {

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm").equals("bat.y.abcdefghi"));
        System.out.println(solution("z-+.^.").equals("z--"));
        System.out.println(solution("=.=").equals("aaa"));
        System.out.println(solution("123_.def").equals("123_.def"));
        System.out.println(solution("abcdefghijklmn.p").equals("abcdefghijklmn"));
    }

    public static String solution(String new_id) {
        // 1단계
        new_id = new_id.toLowerCase();

        // 2단계
        String regex = "[^a-z0-9-_.]";
        new_id = new_id.replaceAll(regex, "");


        // 3단계
        while (new_id.indexOf("..") != -1) {
            new_id = new_id.replace("..", ".");
        }


        // 4단계
        if (new_id.length() > 0 && new_id.charAt(0) == '.') {
            StringBuilder sb = new StringBuilder(new_id);
            sb.deleteCharAt(0);
            new_id = sb.toString();
        }


        // 4단계
        new_id = deleteLastDot(new_id);


        // 5단계
        if (new_id.length() == 0) {
            new_id = "a";
        }

        // 6단계
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
        }

        new_id = deleteLastDot(new_id);

        // 7 단계
        while (new_id.length() <= 2) {
            StringBuilder sb = new StringBuilder(new_id);
            sb.append(new_id.charAt(new_id.length() - 1));
            new_id = sb.toString();
        }

        return new_id;
    }

    private static String deleteLastDot(String new_id) {
        if (new_id.length() <= 0)
            return "";
        int last = new_id.length() > 0 ? new_id.length() - 1 : 0;

        if (new_id.charAt(last) == '.') {
            StringBuilder sb = new StringBuilder(new_id);
            sb.deleteCharAt(last);
            new_id = sb.toString();
        }
        return new_id;
    }


}
