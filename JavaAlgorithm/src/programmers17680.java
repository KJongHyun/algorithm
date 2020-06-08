import java.util.ArrayList;
public class programmers17680 {

        public int solution(int cacheSize, String[] cities) {
            // 캐시를 사용하지 않는경우
            if (cacheSize == 0)
                return 5 * cities.length;
            int answer = 0;
            ArrayList<String> cityCache = new ArrayList<>();
            for (String city : cities) {
                if (cityCache.indexOf(city.toLowerCase()) > -1) {
                    cacheHit(cityCache, cityCache.indexOf(city.toLowerCase()));
                    answer += 1;
                } else {
                    missCache(cityCache, cacheSize, city.toLowerCase());
                    answer += 5;
                }
            }
            return answer;
        }

        public static void missCache(ArrayList<String> cache, int cacheSize, String target) {
            if (cache.size() < cacheSize) {
                cache.add(target);
            } else {
                cache.remove(0);
                cache.add(target);
            }
        }

        public static void cacheHit(ArrayList<String> cache, int index) {
            String temp = cache.get(index);
            cache.remove(index);
            cache.add(temp);
        }

}
