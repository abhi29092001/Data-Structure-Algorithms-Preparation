// TC -> O(n^2)
// SC -> O(1)

public class TwoSumBrute {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums, target));;
    }

    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[2];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }
}
