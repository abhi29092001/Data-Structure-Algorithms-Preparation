public class TwoSumOptimal {
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
        int i = 0;
        int j = numbers.length - 1;

        while (i < j) {
            if ((numbers[i] + numbers[j]) == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                return result;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else if (numbers[i] + numbers[j] > target) {
                j--;
            }
        }

        return new int[] {};
    }
}
