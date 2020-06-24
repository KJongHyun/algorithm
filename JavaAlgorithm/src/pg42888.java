import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class pg42888 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] ans = solution(record);
        System.out.println(ans);
    }

    static class PrintMessage {
        String id;
        String methodMessage;
        public PrintMessage(String id, String methodMessage) {
            this.id = id;
            this.methodMessage = methodMessage;
        }
    }


    public static String[] solution(String[] records) {
        String[] ans;
        List<PrintMessage> ansList = new ArrayList<>();
        HashMap<String, String> idNickMap = new HashMap<>();
        for (String record : records) {
            String[] splitedRecord = record.split("\\s");
            String method = splitedRecord[0];
            String id = splitedRecord[1];
            String nickname = "";
            if (!method.equals("Leave"))
                nickname = splitedRecord[2];

            if (method.equals("Enter")) {
                idNickMap.put(id, nickname);
                ansList.add(new PrintMessage(id, "님이 들어왔습니다."));
            } else if (method.equals("Leave")) {
                ansList.add(new PrintMessage(id, "님이 나갔습니다."));
            } else if (method.equals("Change")) {
                idNickMap.put(id, nickname);
            }
        }

        ans = new String[ansList.size()];
        int index = 0;
        for (PrintMessage printMessage : ansList) {
            ans[index++] = idNickMap.get(printMessage.id) + printMessage.methodMessage;
        }


        return ans;
    }
}
