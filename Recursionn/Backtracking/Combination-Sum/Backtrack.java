// TC -> O(no. of combinations * k)- k for copying diary into new list
// SC -> O(target)-recursion stack space

import java.util.*;

public class Backtrack {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }    

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> diary = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, candidates.length, target, 0, 0, diary, result);
        return result;
    }

    public static void helper(int[] candidates, int n, int target, int i, int sum, List<Integer> diary, List<List<Integer>> result) {
        if (i == n) {
            if (sum == target) {
                result.add(new ArrayList<>(diary));
            }
            return;
        }

        // looping on same index if condition met
        if (sum + candidates[i] <= target) {
            diary.add(candidates[i]);
            sum += candidates[i];
            helper(candidates, n, target, i, sum, diary, result);
            diary.remove(diary.size() - 1);
            sum -= candidates[i];
        }

        // moving forward without taking element at index i
        helper(candidates, n, target, i + 1, sum, diary, result);
    }
}
