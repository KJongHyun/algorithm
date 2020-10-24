import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Nhn1 {
    static int currentIndex = 0;
    static PlayerInfo currentTagger;
    static int numOfAllPlayers;

    private static class PlayerInfo {
        char player;
        int count = 0;

        public PlayerInfo(char player) {
            this.player = player;
        }
    }
    private static void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames, int[] numOfMovesPerGame){
        // TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
        Nhn1.numOfAllPlayers = numOfAllPlayers;

        PlayerInfo playerInfo = new PlayerInfo('A');
        playerInfo.count = 1;

        currentTagger = playerInfo;

        int taggerLocation = 0;

        PlayerInfo[] seats = new PlayerInfo[numOfAllPlayers - 1];

        for (int i = 0; i < seats.length; i++) {
            seats[i] = new PlayerInfo((char)('B' + i));
        }

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < namesOfQuickPlayers.length; i++) {
            set.add(namesOfQuickPlayers[i]);
        }

        for (int i = 0; i < numOfMovesPerGame.length; i++) {
            taggerLocation = getNewTaggerLocation(numOfMovesPerGame[i], taggerLocation);
            PlayerInfo target = seats[taggerLocation];
            if (set.contains(target.player)) {
                currentTagger.count++;
            } else {
                PlayerInfo newTagger = seats[taggerLocation];
                newTagger.count++;
                seats[taggerLocation] = currentTagger;
                currentTagger = newTagger;
            }
        }

        for (int i = 0; i < seats.length; i++) {
            System.out.println(seats[i].player + " " + seats[i].count);
        }

        System.out.println(currentTagger.player + " " + currentTagger.count);
    }

    private static int getNewTaggerLocation(int move, int taggerLocation) {
        taggerLocation += move;
        if (taggerLocation < 0) {
            taggerLocation = numOfAllPlayers - 1  + taggerLocation;
        } else if (taggerLocation >= numOfAllPlayers - 1) {
            taggerLocation %= numOfAllPlayers - 1;
        }

        return taggerLocation;
    }

    private static class InputData {
        int numOfAllPlayers;
        int numOfQuickPlayers;
        char[] namesOfQuickPlayers;
        int numOfGames;
        int[] numOfMovesPerGame;
    }

    private static InputData processStdin() {
        InputData inputData = new InputData();

        try (Scanner scanner = new Scanner(System.in)) {
            inputData.numOfAllPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));

            inputData.numOfQuickPlayers = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.namesOfQuickPlayers = new char[inputData.numOfQuickPlayers];
            System.arraycopy(scanner.nextLine().trim().replaceAll("\\s+", "").toCharArray(), 0, inputData.namesOfQuickPlayers, 0, inputData.numOfQuickPlayers);

            inputData.numOfGames = Integer.parseInt(scanner.nextLine().replaceAll("\\s+", ""));
            inputData.numOfMovesPerGame = new int[inputData.numOfGames];
            String[] buf = scanner.nextLine().trim().replaceAll("\\s+", " ").split(" ");
            for(int i = 0; i < inputData.numOfGames ; i++){
                inputData.numOfMovesPerGame[i] = Integer.parseInt(buf[i]);
            }
        } catch (Exception e) {
            throw e;
        }

        return inputData;
    }

    public static void main(String[] args) throws Exception {
        InputData inputData = processStdin();

        solution(inputData.numOfAllPlayers, inputData.numOfQuickPlayers, inputData.namesOfQuickPlayers, inputData.numOfGames, inputData.numOfMovesPerGame);
    }
}