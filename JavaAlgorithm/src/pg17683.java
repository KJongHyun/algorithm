import java.time.Duration;
import java.time.LocalDateTime;

public class pg17683 {
    public static void main(String[] args) {
        String[] musicInfos = {
                "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"
        };
        String m = "ABCDEFG";

        String[] musicInfos2 = {
                "03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"
        };
        String m2 = "CC#BCC#BCC#BCC#B";

        String[] musicInfos3 = {
                "00:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"
        };
        String m3 = "ABC";

        System.out.println(solution(m3, musicInfos3));
    }

    public static class Music {
        String title;
        long minutes;

        public Music(String title, long minutes) {
            this.title = title;
            this.minutes = minutes;
        }
    }

    public static String solution(String m, String[] musicinfos) {
        String convertedM = convertSharp(m);
        Music matchMusic = null;
        for (String musicInfo : musicinfos) {
            String[] split = musicInfo.split(",");
            String[] startTime = split[0].split(":");
            String[] endTime = split[1].split(":");
            String title = split[2];
            LocalDateTime startLocalDateTime = LocalDateTime.of(2020, 7, 21, Integer.parseInt(startTime[0]), Integer.parseInt(startTime[1]));
            LocalDateTime endLocalDateTime = LocalDateTime.of(2020, 7, 21, Integer.parseInt(endTime[0]), Integer.parseInt(endTime[1]));

            Duration duration = Duration.between(startLocalDateTime, endLocalDateTime);
            long minutes = duration.toMinutes();
            String musicSheet = convertSharp(split[3]);

            String fullMusic = playMusic(musicSheet, minutes);

            //조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
            if (fullMusic.indexOf(convertedM) != -1) {
                Music music = new Music(title, minutes);
                if (matchMusic != null) {
                   matchMusic = matchMusic.minutes >= music.minutes ? matchMusic : music;
                } else {
                    matchMusic = music;
                }
            }
        }


        return "`(None)`";
    }

    public static String convertSharp(String musicSheet) {
        String convertedMusicSheet = musicSheet.replace("C#", "c");
        convertedMusicSheet = convertedMusicSheet.replace("D#", "d");
        convertedMusicSheet = convertedMusicSheet.replace("F#", "f");
        convertedMusicSheet = convertedMusicSheet.replace("G#", "g");
        convertedMusicSheet = convertedMusicSheet.replace("A#", "a");

        return convertedMusicSheet;
    }

    public static String playMusic(String musicSheet, long minutes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < minutes; i++) {
            stringBuilder.append(musicSheet.charAt(i % musicSheet.length()));
        }

        return stringBuilder.toString();
    }
}
