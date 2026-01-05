// TC -> O(n)
// SC -> O(n)

import java.util.HashMap;

public class TwoSumBetter {
    public static void main(String[] args) {
        int[] numbers = {-1, 0};
        int target = -1;
        int[] result = twoSum(numbers, target);

        if (result.length == 0) {
            System.out.println("Not found");
        } else {
            for (int el : result) {
                System.out.print(el + " ");
            }
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> hashmap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            hashmap.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length; i++) {
            int required = target - numbers[i];

            if (hashmap.containsKey(required)) {
                result[0] = i + 1;
                result[1] = hashmap.get(required) + 1;
                return result;
            }
        }

        return new int[] {};
    }
}
