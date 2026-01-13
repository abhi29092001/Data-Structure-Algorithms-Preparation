// TC -> O(n^2)
// SC -> O(1)

import java.util.Arrays;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        int sum = 2;
        System.out.println(solution(nums, sum));
    }

    public static int solution(int[] nums, int sum) {
        int n = nums.length;
        Arrays.sort(nums);
        int count = 0;
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            
            while (left < right) {
                int tripletSum = nums[i] + nums[left] + nums[right];
                
                if (tripletSum < sum) {
                    count += (right - left);
                    left++;
                } else if (tripletSum >= sum) {
                    right--;
                }
            }
        }
        return count;
    }
}
