// TC -> O(m*n log(m*n))
// SC -> O(1)

import java.util.*;

public class Brute {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int k = 5;
        System.out.println(findKthNumber(m, n, k));
    }   
    
    public static int findKthNumber(int m, int n, int k) {
        // Logic -
        // Create 1D array by using m * n multiplication table
        // Sort 1D array
        // Return kth smallest element

        int[] arr = new int[m * n];
        int index = 0;

        // create 1D array of m * n multiplication table
        for (int i = m; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                arr[index] = i * j;
                index++;
            }
        }

        // Sorting
        Arrays.sort(arr);

        return arr[k - 1];
    }
}
