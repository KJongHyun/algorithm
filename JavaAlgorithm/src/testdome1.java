import java.util.HashSet;
import java.util.Set;

public class testdome1 {
    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> nameSet = new HashSet<>();
        for (String name : names1) {
            nameSet.add(name);
        }

        for (String name : names2) {
            nameSet.add(name);
        }
        String[] nameArr = new String[nameSet.size()];
        nameSet.toArray(nameArr);
        return nameArr;
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", testdome1.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
