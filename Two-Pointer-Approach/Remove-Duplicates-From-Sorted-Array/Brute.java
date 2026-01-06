// TC -> O(nlogn)
// SC -> O(n)

import java.util.Set;
import java.util.TreeSet;

public class Brute {
    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int uniqueElements = solution(nums);
        System.out.println(uniqueElements);
    }

    public static int solution(int[] nums) {
        int i = 0;

        Set<Integer> set = new TreeSet<>();
        
        for (int num : nums) {
            Integer wrapperInt = num;
            set.add(wrapperInt);
        }

        for (Integer num : set) {
            nums[i] = num;
            i++;
        }
        return set.size();
    }
}
