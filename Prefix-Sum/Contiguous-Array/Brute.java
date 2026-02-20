// TC -> O(n^2)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1,1,0,0,0};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int zeroesCount = 0;
            int onesCount = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] == 1) {
                    onesCount++;
                } else {
                    zeroesCount++;
                }

                if (zeroesCount == onesCount && maxLen < (j - i + 1)) {
                    maxLen = j - i + 1;
                }
            }
        }

        return maxLen;
    }
}
