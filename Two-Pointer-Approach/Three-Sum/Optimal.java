// TC -> O(n^2)
// SC -> O(logn)- recursive stack space used during sorting

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(solution(nums));
    }

    public static List<List<Integer>> solution(int[] nums) {
        // Logic-
        // need triplets whose sum is 0
        // we'll take 2 elements sum and find out whether its equal to negative of first -> a[j]+a[k] = -a[i] is same as a[i]+a[j]+a[k] = 0
        // sort elements so that we can use 2 pointers technique over here
        // make sure you dont consider duplicates for indices i,j,k
        // store triplets once you get it
        // then return final result


        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = n - 1;
            int target = -1 * nums[i];

            while (j < k) {
                List<Integer> triplets = new ArrayList<>();
                int sum = nums[j] + nums[k];

                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(nums[k]);
                    j++;
                    k--;

                    while (j < n && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while (k > 0 && k < n - 1 && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }

                if (triplets.size() > 0) result.add(triplets);
            }
        }

        return result;
    }
}
