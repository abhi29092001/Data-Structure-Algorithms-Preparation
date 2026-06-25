// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {-2, 3, -4};
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        // Logic-
        // product of two negative numbers is always +ve 
        // if there are 4 -ve numbers then after multiplication of 2 numbers the result will be +ve and when 3rd number comes into picture then the result will become -ve again
        // but we cant ignore that number coz 4th number is also -ve so the final result will be +ve 
        // in short we have to also track minimum ending best to get maximum product of subarray
        // thats why both maxending and minending bests are required in this ques
        // find all 3 possibilities and find min and max from them and finally ans from both maxending and minending
        // technically we can ignore minending while finding max for ans, coz at that time minending will be holding minimum value

        int n = nums.length;
        int maxEnding = nums[0];
        int minEnding = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int val1 = maxEnding * nums[i];
            int val2 = minEnding * nums[i];
            int val3 = nums[i];

            maxEnding = Math.max(Math.max(val1, val2), val3);
            minEnding = Math.min(Math.min(val1, val2), val3);
            // ans = Math.max(Math.max(minEnding, maxEnding), ans);
            ans = Math.max(ans, maxEnding);
        }
        
        return ans;
    }
}
