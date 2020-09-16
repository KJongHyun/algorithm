public class leetCode8 {

    public static void main(String[] args) {
        System.out.println(myAtoi("20000000000000000000"));
    }

    public static int myAtoi(String str) {
        String[] split = str.split("");
        for (int i = 0; i < split.length; i++) {
            if (split[i].equals(" ")) {
                split[i] = "";
            } else {
                break;
            }
        }
        str = String.join("", split);

        String regex = "^[^(0-9-+)](.*)";

        if (str.matches(regex)) {
            return 0;
        }

        for (int i = 0; i < str.length(); i++) {
            if (i != 0 && !(str.charAt(i) >= '0' && str.charAt(i) <= '9')) {
                str = str.substring(0, i);
                break;
            }
        }

        Double longValue;

        longValue = Double.valueOf(str);


        if (longValue > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (longValue < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) longValue.doubleValue();
        }
    }
}
