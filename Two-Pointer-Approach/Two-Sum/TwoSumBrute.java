// TC -> O(n^2)
// SC -> O(1)

public class TwoSumBrute {
    public static void main(String[] args) {
        int[] numbers = {-1, 0};
        int target = -1;
        int[] result = twoSum(numbers, target);

        if (result.length == 0) {
            System.out.println("Not found");
        } else {
            for (int el : result) {
                System.out.print(el + " ");
            }
        }
    }

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            int required = target - numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == required) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }

        return new int[] {};
    }
}
