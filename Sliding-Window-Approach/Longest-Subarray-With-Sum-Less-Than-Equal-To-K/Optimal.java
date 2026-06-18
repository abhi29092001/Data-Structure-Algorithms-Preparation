// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 7, 4, 2, 1, 1, 5};
        int k = 8;
        System.out.println(findLength(nums, k));
    }    

    public static int findLength(int[] nums, int k) {
        // Logic-
        // we'll use sliding window in this ques
        // use two pointers, low will stay at same place and high will move
        // if addition of high in sum is lesser than equal to k then take it, update len and check whether maxlen is lesser if yes store len in maxlen
        // if addition of high results in sum > k then shrink down the window from left side until the sum > k condition become false
        // finally return maxlen 

        int n = nums.length;
        int maxLen = 0;
        int low = 0;
        int high = 0;
        int sum = 0;

        while (low < n && high < n) {
            sum += nums[high];
            int len = high - low + 1;

            while (sum > k) {
                sum -= nums[low];
                low++;
                len = high - low + 1;
            }

            if (len > maxLen) {
                maxLen = len;
            }

            high++;
        }

        return maxLen;
    }    
}
