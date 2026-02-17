// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {2, -1, 1};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftSum = 0;
        int rightSum = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        for (int i = 0; i < n; i++) {
            // Updated right sum(excluded nums[i] and left sum) to compare it with left sum, just after i updation
            rightSum = sum - nums[i] - leftSum;

            if (leftSum == rightSum) {
                return i;
            }

            // updated left sum just before increment of i, coz left sum is 0...i-1 so that we can compare it with right sum just after right sum updation coz i got incremented and right sum is i+1...n-1
            leftSum = leftSum + nums[i];
        }

        return -1;
    }    
}
