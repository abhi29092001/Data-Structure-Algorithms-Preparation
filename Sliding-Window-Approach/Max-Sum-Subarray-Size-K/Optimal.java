// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        System.out.println(solution(arr, k));
    }

    public static int solution(int[] arr, int k) {
        // Logic -
        // its clearly mentioned that we have to use sliding window in this, as ques says we need to find max sum subarray of size k
        // first find sum of first window
        // then compare with maxsum if its maximum take it and move forward
        // before incrementing low, make sure you remove previous low from sum
        // before adding high into sum, check if it still lies in array boundary
        // keep on doing same thing till high doesnt exceeds n
        // break and return maxsum

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
            
            high++;
            sum -= arr[low];
            low++;
            
            if (high == n) {
                break;
            } else {
                sum += arr[high]; 
            }
        }

        return maxSum;
    }
}
