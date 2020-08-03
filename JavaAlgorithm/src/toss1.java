import java.io.*;
public class toss1 {
    public static void main(String[] args) throws Exception {

//        문자열은 1 과 2 로만 구성된다.
//
//        1의 뒤는 항상 2 가 존재해﻿야만 한다.
//
//        2의 뒤는 1 혹은 2 가 존재할 수 있다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        System.out.println(solution(input));

    }

    public static boolean solution(String input) {
        if(input.charAt(input.length() - 1) == '1')
            return false;
        char pre = '2';
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1' && pre == '1') {
                return false;
            }
            pre = input.charAt(i);
        }

        return true;
    }
}
