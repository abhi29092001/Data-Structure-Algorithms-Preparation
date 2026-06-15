// TC -> O(n)
// SC -> O(n)

// one pass solution

import java.util.*;

public class TwoSumOptimal {
    public static void main(String[] args) {
        int[] nums = {-1, 0};
        int target = -1;
        System.out.println(twoSum(nums, target));
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int remaining = target - nums[i];

            if (map.containsKey(remaining)) {
                result[0] = i;
                result[1] = map.get(remaining);
                break;
            } else {
                map.put(nums[i], i);
            }
        }

        return result;
    }
}
