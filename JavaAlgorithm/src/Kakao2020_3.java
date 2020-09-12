import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Kakao2020_3 {

    static Map<String, List<CandidateInfo>> cache = new HashMap<>();
    static String[] languageList = {"cpp", "java", "python", "-"};
    static String[] jobGroupList = {"backend", "frontend", "-"};
    static String[] careerList = {"junior", "senior", "-"};
    static String[] soulFoodList = {"chicken", "pizza", "-"};


    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        solution(info, query);
    }

    public static int[] solution(String[] info, String[] query) {
        List<CandidateInfo> candidateInfoList = new ArrayList<>();
        for (String strInfo : info) {
            String[] split = strInfo.split(" ");
            candidateInfoList.add(new CandidateInfo(split[0], split[1], split[2], split[3], Integer.valueOf(split[4])));
        }

        int[] answer = new int[query.length];
        int index = 0;
        for (String strQuery : query) {
            strQuery = strQuery.replaceAll(" and", "");
            String[] split = strQuery.split(" ");
            List<CandidateInfo> list = candidateInfoList;

            StringBuilder currentQuery = new StringBuilder();
            String language = split[0];
            currentQuery.append(language);
            list = getMatchList(list, currentQuery.toString(), "language", language);

            String jobGroup = split[1];
            currentQuery.append(jobGroup);
            list = getMatchList(list, currentQuery.toString(), "jobGroup", jobGroup);

            String career = split[2];
            currentQuery.append(career);
            list = getMatchList(list, currentQuery.toString(), "career", career);

            String soulFood = split[3];
            currentQuery.append(soulFood);
            list = getMatchList(list, currentQuery.toString(), "soulFood", soulFood);


            int score = Integer.valueOf(split[4]);

            int targetCount = 0;
            for (CandidateInfo candidateInfo : list) {
                if (candidateInfo.score >= score) {
                    targetCount++;
                }
            }

            answer[index++] = targetCount;
        }


        return answer;
    }

    private static List<CandidateInfo> getMatchList(List<CandidateInfo> list, String currentQuery, String targetField, String targetBase) {
        if (cache.containsKey(currentQuery)) {
            list = cache.get(currentQuery);
        } else {
            if (targetBase.equals("-")) {
                cache.put(currentQuery, list);
                return list;
            }
            List<CandidateInfo> newList = new ArrayList<>();
            for (CandidateInfo candidateInfo : list) {
                if (getFieldData(candidateInfo, targetField).equals(targetBase)) {
                    newList.add(candidateInfo);
                }
            }
            cache.put(currentQuery, newList);
            list = newList;
        }
        return list;
    }

    private static String getFieldData(CandidateInfo candidateInfo, String targetField) {
        switch (targetField) {
            case "language" :
                return candidateInfo.language;
            case "jobGroup" :
                return candidateInfo.jobGroup;
            case "career" :
                return candidateInfo.career;
            case "soulFood" :
                return candidateInfo.soulFood;
            default:
                return "";
        }
    }


    static class CandidateInfo {
        String language;
        String jobGroup;
        String career;
        String soulFood;
        int score;

        public CandidateInfo(String language, String jobGroup, String career, String soulFood, int score) {
            this.language = language;
            this.jobGroup = jobGroup;
            this.career = career;
            this.soulFood = soulFood;
            this.score = score;
        }
    }

    public static int[] solution2(String[] info, String[] query) {
        List<CandidateInfo> candidateInfoList = new ArrayList<>();
        for (String strInfo : info) {
            String[] split = strInfo.split(" ");
            candidateInfoList.add(new CandidateInfo(split[0], split[1], split[2], split[3], Integer.valueOf(split[4])));
        }
        for (String language : languageList) {
            List<CandidateInfo> list = candidateInfoList;
            list = getMatchList(list, language, "language", language);
            for (String jobGroup : jobGroupList) {
                List<CandidateInfo> list2 = getMatchList(list, language + jobGroup, "jobGroup", jobGroup);
                for (String career : careerList) {
                    List<CandidateInfo> list3 = getMatchList(list2, language + jobGroup + career, "career", career);
                    for (String soulFood : soulFoodList) {
                        List<CandidateInfo> list4 = getMatchList(list3, language + jobGroup + career + soulFood, "soulFood", soulFood);
                    }
                }
            }
        }
        int[] answer = new int[query.length];
        int index = 0;
        for (String strQuery : query) {
            strQuery = strQuery.replaceAll(" and ", "");
            String[] split = strQuery.split(" ");
            List<CandidateInfo> list = cache.get(split[0]);
            int score = Integer.valueOf(split[1]);

            int targetCount = 0;
            for (CandidateInfo candidateInfo : list) {
                if (candidateInfo.score >= score) {
                    targetCount++;
                }
            }

            answer[index++] = targetCount;
        }

        return answer;

    }

}
