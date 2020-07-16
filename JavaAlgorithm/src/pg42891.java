import com.sun.deploy.security.CredentialManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class pg42891 {

    public static class Food {
        int amount;
        int order;

        public Food(int amount, int order) {
            this.amount = amount;
            this.order = order;
        }

        public void eat() {
            this.amount--;
        }
    }

    public static void main(String[] args) {
        int[] food_times = {3,1,1,1,2,4,3 };
        int ans = solution(food_times, 12);

        System.out.println(ans);
    }

    public static int solution(int[] food_times, long k) {

        int length = food_times.length;

        int foodAmount = length;

        List<Food> foodAmountList = new ArrayList<>();



        int i = 1;
        for (Integer food : food_times) {
            foodAmountList.add(new Food(food, i++));
        }

        long start = 0;
        long end = start + 1;
        boolean isObstacle = false;
        Food currentFood = null;
        while (true) {
            if (foodAmountList.size() == 0) {
                return -1;
            }
            if (isObstacle) {
                return currentFood.order;
            }
            int foodIndex = 0;
            List<Food> removeList = new ArrayList<>();
            for (Food foodElement : foodAmountList) {
                currentFood = foodElement;
                if (start == k) {
                    isObstacle = true;
                    break;
                }
                currentFood.eat();
                if (currentFood.amount == 0) {
                    removeList.add(currentFood);
                }
                if (end == k) {
                    isObstacle = true;
                    if (foodIndex == foodAmountList.size() - 1) {
                        currentFood = foodAmountList.get(0);
                    }
                }
                foodIndex++;
                start++;
                end = start + 1;
            }

            for (Food food : removeList) {
                foodAmountList.remove(food);
            }
        }
    }

    public static void eat(int[] food_times, int index) {

    }
}
