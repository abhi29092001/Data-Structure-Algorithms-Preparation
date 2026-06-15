// TC -> O(n)
// SC -> O(n)

import java.util.*;

public class TwoSumBetter {
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
            map.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int remaining = target - nums[i];

            if (map.containsKey(remaining) && map.get(remaining) != i) {
                result[0] = i;
                result[1] = map.get(remaining);
                break;
            }
        }

        return result;
    }
}
