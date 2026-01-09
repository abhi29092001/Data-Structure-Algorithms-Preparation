// TC -> O(n^3)
// SC -> O(n^2)

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Arrays;

public class Brute {
    public static void main(String[] args) {
        int[] nums = {0,1,1};
        List<List<Integer>> result = solution(nums);
        System.out.println(result);
    }   
    
    public static List<List<Integer>> solution(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplets = new ArrayList<>();
                        triplets.add(nums[i]);
                        triplets.add(nums[j]);
                        triplets.add(nums[k]);
                        result.add(triplets);
                    }
                }
            }
        }

        return new ArrayList<>(result);
    }
}
