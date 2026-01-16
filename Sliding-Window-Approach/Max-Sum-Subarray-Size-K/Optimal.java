// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        System.out.println(solution(arr, k));
    }

    public static int solution(int[] arr, int k) {
        int n = arr.length;
        int maxSum = 0;
        int sum = 0;
        int low = 0;
        int high = k - 1;
        
        for (int i = low; i <= high; i++) {
            sum += arr[i];
        }
        
        while (high < n) {
            if (sum > maxSum) {
                maxSum = sum;
            }
            
            low++;
            high++;
            sum -= arr[low - 1];
            
            if (high == n) {
                break;
            } else {
                sum += arr[high]; 
            }
        }
        return maxSum;
    }
}
