public class boj5373 {
    static final int U = 0;
    static final int D = 1;
    static final int F = 2;
    static final int B = 3;
    static final int L = 4;
    static final int R = 5;
    static String [][][] cube = {
            {
                    {"w", "w", "w"},
                    {"w", "w", "w"},
                    {"w", "w", "w"}
            },
            {
                    {"y", "y", "y"},
                    {"y", "y", "y"},
                    {"y", "y", "y"},
            },
            {
                    {"r", "r", "r"},
                    {"r", "r", "r"},
                    {"r", "r", "r"}
            },
            {
                    {"o", "o", "o"},
                    {"o", "o", "o"},
                    {"o", "o", "o"}
            },
            {
                    {"g", "g", "g"},
                    {"g", "g", "g"},
                    {"g", "g", "g"}
            },
            {
                    {"b", "b", "b"},
                    {"b", "b", "b"},
                    {"b", "b", "b"}
            }

    } ;

    public static void main(String[] args) {

    }

    public static void rotate(int side, int direction) {

    }

    public static void print() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cube[U][i][j]);
            }
            System.out.println();
        }
    }
}
