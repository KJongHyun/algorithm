import java.util.Scanner;

class Nhn2 {
    private static void solution(int day, int width, int[][] blocks) {
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        int[] wall = new int[width + 1];

        int cement = 0;
        for (int i = 0; i < day; i++) {
            for (int j = 0; j < width; j++) {
                wall[j] += blocks[i][j];
            }
            int leftBlock = 0;
            int rightBlock = 0;
            while (rightBlock < width && leftBlock < width) {
                if (leftBlock  + 1 < width && wall[leftBlock] <= wall[leftBlock + 1]) {
                    leftBlock++;
                }

                if (rightBlock - leftBlock > 1 && wall[rightBlock]  > wall[rightBlock + 1]) {
                    int addCement = pourCement(leftBlock, rightBlock, wall);
                    cement += addCement;
                    leftBlock = rightBlock;
                } else {
                    rightBlock++;
                }
            }
        }

        System.out.println(cement);
    }

    private static int pourCement(int leftBlock, int rightBlock, int[] wall) {
        int sum = 0;
        int min = Math.min(wall[leftBlock], wall[rightBlock]);
        for (int i = leftBlock + 1; i < rightBlock; i++) {
            if (wall[i] < min) {
                sum += min - wall[i];
                wall[i] = min;
            }
        }
        return sum;
    }


    private static class InputData {
        int day;
        int width;
        int[][] blocks;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.day = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.width = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.blocks = new int[inputData.day][inputData.width];
            for (int i = 0; i < inputData.day; i++) {
                String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
                for (int j = 0; j < inputData.width; j++) {
                    inputData.blocks[i][j] = Integer.parseInt(buf[j]);
                }
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.day, inputData.width, inputData.blocks);
    }
}