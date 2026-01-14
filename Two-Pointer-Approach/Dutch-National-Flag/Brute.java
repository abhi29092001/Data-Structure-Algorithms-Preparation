// TC -> O(n)
// SC -> O(n)

import java.util.ArrayList;

public class Brute {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        solution(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void solution(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> zeroes = new ArrayList<>();
        ArrayList<Integer> ones = new ArrayList<>();
        ArrayList<Integer> twos = new ArrayList<>();
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroes.add(nums[i]);
            } else if (nums[i] == 1) {
                ones.add(nums[i]);
            } else {
                twos.add(nums[i]);
            }
        }

        for (Integer zero : zeroes) {
            nums[index] = zero;
            index++;
        }
        for (Integer one : ones) {
            nums[index] = one;
            index++;
        }
        for (Integer two : twos) {
            nums[index] = two;
            index++;
        }
    }
}
