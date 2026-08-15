// TC -> O(n * 2^n)
// SC -> O(n * 2^n)

import java.util.ArrayList;
import java.util.List;

public class Backtrack {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println();
    }    

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, nums, nums.length, 0, new ArrayList<>());
        return result;
    }

    public void helper(List<List<Integer>> result, int[] nums, int n, int i, List<Integer> diary) {
        // Logic-
        // creating all subsets using backtracking 

        if (i == n) {
            // creating new list and then copying diary into it coz diary will be mutated at every point and if we directly add diary then when changes happen in diary then those changes will also reflect in result list, resulting in incorrect output
            result.add(new ArrayList<>(diary));
            return;
        }

        // Not Taken
        helper(result, nums, n, i + 1, diary);

        // Taken
        diary.add(nums[i]);
        helper(result, nums, n, i + 1, diary);
        diary.remove(diary.size() - 1);
    }
}
