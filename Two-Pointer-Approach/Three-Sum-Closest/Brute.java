// TC -> O(n^3)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        System.out.println(solution(nums, target));
    }

    public static int solution(int[] nums, int target) {
        int closestDiff = 10000;
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2];

        if (n == 3) {
            return closestSum;
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    int diff = Math.abs(target - sum);

                    if (diff < closestDiff) {
                        closestDiff = diff; 
                        closestSum = sum;
                    }
                }
            }
        }
        return closestSum;
    }
}
