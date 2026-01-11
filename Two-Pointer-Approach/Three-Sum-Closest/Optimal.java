// TC -> O(n^2)
// SC -> O(1)

import java.util.Arrays;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(solution(nums, target));
    }

    public static int solution(int[] nums, int target) {
        int closestDiff = 10000;
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        // atleast 3 numbers will be there so no computation is needed directly sum can be returned
        if (n == 3) {
            return closestSum;
        }

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                int diff = Math.abs(sum - target);

                if (closestDiff > diff) {
                    closestDiff = diff;
                    closestSum = sum;
                }

                if (sum == target) {
                    return closestSum;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }
}
