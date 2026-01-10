// TC -> O(n^2)
// SC -> O(1)

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {0,1,1};
        System.out.println(solution(nums));
    }

    public static List<List<Integer>> solution(int[] nums) {
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n-2; i++) {
            if (i > 0 && (nums[i] == nums[i-1])) {
                continue;
            }
            
            int target = -1 * nums[i];
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];

                if (sum < target) {
                    left++;
                } else if (sum > target) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    while (left < (n-1) && nums[left] == nums[left-1]) {
                        left++;
                    }

                    while (right > 0 && nums[right] == nums[right+1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
