// TC -> O(n^2)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int k = 8;
        System.out.println(findLength(nums, k));
    }    

    public static int findLength(int[] nums, int k) {
        // Logic-
        // use two loops, i will stay at same place and j will move
        // if addition of nums[j] in sum is lesser than equal to k then take it, update len and check whether max len is lesser if yes store len in maxlen
        // if addition of nums[j] results in false then break out of loop and increment i to check for another subarray
        // finally return maxlen 

        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i];
            int len = 1;

            for (int j = i + 1; j < n; j++) {
                if (sum + nums[j] <= k) {
                    sum += nums[j];
                    len = j - i + 1;

                    if (len > maxLen) {
                        maxLen = len;
                    }
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }
}
