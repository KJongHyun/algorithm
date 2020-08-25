import java.util.ArrayList;
import java.util.List;

public class leetCode6 {
    public static void main(String[] args) {
        System.out.println(convert("AB", 2));
    }

    public static String convert(String s, int numRows) {
        List<RowData> rowDataList = new ArrayList<>();
        int numRow = 1;
        boolean isReverse = false;
        for (int i = 0; i < s.length(); i++) {
            if (numRow == 1) {
                isReverse = false;
            }  else if (numRow == numRows){
                isReverse = true;
            }

            rowDataList.add(new RowData(s.charAt(i), numRow));
            if (numRows == 1)
                continue;
            if (isReverse) {
                numRow--;
            } else {
                numRow++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= numRows; i++) {
            int finalI = i;
            rowDataList.stream().filter(t -> t.row == finalI).forEach(t ->
                sb.append(t.c));
        }

        return sb.toString();
    }

    static class RowData {
        char c;
        int row;
        public RowData(char c, int row) {
            this.c = c;
            this.row =row;
        }
    }
}
