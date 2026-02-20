// TC -> O(n)
// SC -> O(n)

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1,1,0,0,0};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        // variable for counting number of zeroes in the array
        int zeroes = 0;

        // variable for counting number of ones in the array
        int ones = 0;

        // hashmap for storing difference and index as key-value pair, we are storing diff and index at which that diff encountered (we're storing first encountered diff only coz we need max len subarray that's why)
        HashMap<Integer, Integer> diffIndexMapping = new HashMap<>();

        // edge case - if the whole array is the answer, and why index -1? coz in starting we haven't encountered any subarray with diff 0 that's why its -1
        diffIndexMapping.put(0, -1);

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                ones++;
            } else {
                zeroes++;
            }

            // finding out diff between zeroes and ones
            int diff = ones - zeroes;

            // checking if the diff exists then will take the index and minus it from i to exclude the red part and get green part's length
            if (diffIndexMapping.containsKey(diff)) {
                maxLen = Math.max(maxLen, i - diffIndexMapping.get(diff));
            } else {
                // if diff doesn't exist then will put it into hashmap
                diffIndexMapping.put(diff, i);
            }
        }

        return maxLen;
    }    
}
