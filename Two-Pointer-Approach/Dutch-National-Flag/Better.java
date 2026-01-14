// TC -> O(n)
// SC -> O(1)

public class Better {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        solution(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void solution(int[] nums) {
        int n = nums.length;
        int zeroes = 0;
        int ones = 0;
        int twos = 0;
        int index = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroes++;
            } else if (nums[i] == 1) {
                ones++;
            } else {
                twos++;
            }
        }

        for (int i = 0; i < zeroes; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < ones; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < twos; i++) {
            nums[index++] = 2;
        }
    }
}
