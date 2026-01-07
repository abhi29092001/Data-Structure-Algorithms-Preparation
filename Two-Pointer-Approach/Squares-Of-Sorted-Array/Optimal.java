// TC -> O(n)
// SC -> O(1) - excluding output array

public class Optimal {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = solution(nums);

        for (int el : result) {
            System.out.print(el + " ");
        }
    }

    public static int[] solution(int[] nums) {
        int n = nums.length;
        int[] resultArray = new int[n];
        int negCount = 0;
        int posCount = 0;
        int index = 0;

        // counting +ve and -ve numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                negCount++;
            } else {
                posCount++;
            }
        }

        if (negCount == n) { // if all elements are negative
            for (int i = n - 1; i >= 0; i--) {
                resultArray[index++] = nums[i] * nums[i];
            }
        } else if (posCount == n) { // if all elements are positive
            for (int i = 0; i < n; i++) {
                resultArray[index++] = nums[i] * nums[i];
            }
        } else { // if array contains both -ve and +ve numbers
            int i = 0;
            int j = n - 1;
            index = n - 1;

            while (i <= j) {
                if (Math.abs(nums[i]) >= Math.abs(nums[j])) {
                    resultArray[index--] = nums[i] * nums[i];
                    i++;
                } else if (Math.abs(nums[i]) <= Math.abs(nums[j])) {
                    resultArray[index--] = nums[j] * nums[j];
                    j--;
                }
            }
        }

        return resultArray;
    }
}
