// TC -> O(n)
// SC -> O(n)

public class Better {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        int[] result = solution(nums);

        for (int el : result) {
            System.out.print(el + " ");
        }
    }

    public static int[] solution(int[] nums) {
        int n = nums.length;
        int[] negatives = new int[n];
        int[] positives = new int[n];
        int[] result = new int[n];
        int negCount = 0;
        int posCount = 0;

        for (int num : nums) {
            if (num < 0) {
                negatives[negCount] = num * num;
                negCount++;
            } else {
                positives[posCount] = num * num;
                posCount++;
            }
        }

        int i = negCount - 1;
        int j = 0;
        int index = 0;

        while (i >= 0 && j < posCount) {
            if (negatives[i] <= positives[j]) {
                result[index] = negatives[i];
                i--;
                index++;
            } else {
                result[index] = positives[j];
                j++;
                index++;
            }
        }

        while (i >= 0) {
            result[index] = negatives[i];
            i--;
            index++;
        }

        while (j < posCount) {
            result[index] = positives[j];
            j++;
            index++;
        }
        return result;
    }
}
