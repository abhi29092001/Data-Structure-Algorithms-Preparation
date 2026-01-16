// TC -> O(n * k)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        System.out.println(solution(arr, k));
    }

    public static int solution(int[] arr, int k) {
        int n = arr.length;
        int maxSum = 0;
        int sum = 0;
        
        for (int i = 0; i < n - k + 1; i++) {
            sum = arr[i];
            for (int j = i + 1; j < k + i; j++) {
                sum += arr[j];
            }
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
