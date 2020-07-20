import java.util.ArrayList;
import java.util.List;

public class pg42891_new {
    public static void main(String[] args) {
        int[] food_times = {3, 1, 1, 1, 2, 4, 3};
        int[] food_times2 = {3, 1, 2};
        int ans = solution(food_times, 12);
        System.out.println(ans);
    }

    public static class Food {
        int amount;
        int order;

        public Food(int amount, int order) {
            this.amount = amount;
            this.order = order;
        }
    }



    public static int solution(int[] food_times, long k) {


        List<Food> foodAmountList = new ArrayList<>();


        int order = 1;
        for (Integer food : food_times) {
            foodAmountList.add(new Food(food, order++));
        }

        foodAmountList.sort((o1, o2) -> {
            if (o1.amount > o2.amount)
                return 1;
            else if (o1.amount < o2.amount)
                return -1;
            else
                return 0;
        });

        int preTime = 0;
        int i = 0;
        for (Food food : foodAmountList) {
            int time = food.amount - preTime;
            if (time != 0) {
                int spendTime = time * (foodAmountList.size() - i);
                if (spendTime > k) {
                    foodAmountList.subList(i, foodAmountList.size()).sort((o1, o2) -> {
                        if (o1.order > o2.order)
                            return 1;
                        else if (o1.order < o2.order)
                            return -1;
                        else
                            return 0;
                    });

                    int index = (int)(k % (foodAmountList.size() - i));
                    return foodAmountList.get(i + index).order;
                }
                k -= spendTime;
                preTime = food.amount;
            }

            i++;
        }


        return -1;
    }

}
