// TC -> O(n^2 logn)
// SC -> O(n^2)

import java.util.*;

public class Brute {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }     

    public static int kthSmallest(int[][] matrix, int k) {
        // Logic - 
        // Create 1D array from 2D array, sort it, and return Kth smallest element

        int n = matrix.length;
        int[] arr = new int[n * n];
        int index = 0;

        // creating 1D array from 2D array
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[index] = matrix[i][j];
                index++;
            }
        }

        // For sorting 1D array to get actual Kth smallest element - O(n^2 logn^2)
        Arrays.sort(arr);

        // for getting kth smallest element
        return arr[k - 1];
    }
}
