// TC -> O(n * n!)
// SC -> O(n * n!)

import java.util.ArrayList;
import java.util.List;

public class Backtrack {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, nums.length, nums, 0);
        return result;
    }

    public static void helper(List<List<Integer>> result, int n, int[] nums, int swapIndex) {
        // Logic-
        // used backtracking with in-place swapping to get all the permutations

        // base case
        if (swapIndex == n) {
            List<Integer> permutation = new ArrayList<>();

            for (int num : nums) permutation.add(num);

            result.add(permutation);
            return;
        }

        for (int j = swapIndex; j < n; j++) {
            swap(nums, swapIndex, j);
            helper(result, n, nums, swapIndex + 1);

            // backtracking
            swap(nums, swapIndex, j); 
        }
    }

    public static void swap(int[] nums, int swapIndex, int j) {
        int temp = nums[swapIndex];
        nums[swapIndex] = nums[j];
        nums[j] = temp;
    }    
}
