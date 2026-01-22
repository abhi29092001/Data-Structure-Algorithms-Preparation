// TC -> O(n)
// SC -> O(1)

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        int[] fruits = {1,2,3,2,2};
        System.out.println(solution(fruits));
    }

    public static int solution(int[] fruits) {
        int n = fruits.length;
        int low = 0; 
        int baskets = 2;
        int maxFruits = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int high = 0; high < n; high++) {
            freq.put(fruits[high], freq.getOrDefault(fruits[high], 0) + 1);

            while (freq.size() > baskets) {
                freq.put(fruits[low], freq.get(fruits[low]) - 1);

                if (freq.get(fruits[low]) == 0) {
                    freq.remove(fruits[low]);
                }

                low++;
            }

            if (freq.size() <= baskets) {
                maxFruits = Math.max(high - low + 1, maxFruits);
            }
        }

        return maxFruits;
    }
}
