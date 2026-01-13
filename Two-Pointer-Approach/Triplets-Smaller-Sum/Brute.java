// TC -> O(n^3)
// Sc -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] nums = {-2, 0, 1, 3};
        int sum = 2;
        System.out.println(solution(nums, sum));
    }

    public static int solution(int[] nums, int sum) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    int tripletSum = nums[i] + nums[j] + nums[k];

                    if (tripletSum < sum) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
