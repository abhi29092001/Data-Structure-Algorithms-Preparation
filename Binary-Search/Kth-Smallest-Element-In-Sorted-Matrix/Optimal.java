// TC -> O(n * log(max - min))
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{10,11,13},{12,13,15}};
        int k = 8;
        System.out.println(kthSmallest(matrix, k));
    }
    
    public static int kthSmallest(int[][] matrix, int k) {
        // Logic-
        // Matrix is a sorted matrix and the kth smallest element definitely will be in the range of min element and max element of matrix. Take a guess means find out mid and check in matrix that how much element are smaller than mid. if count is greater than k then store that element and move to the left side otherwise move to the right side.


        int n = matrix.length;
        int low = matrix[0][0]; // min element of matrix
        int high = matrix[n - 1][n - 1]; // max element of matrix
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (helper(matrix, k, mid, n) < k) {
                low = mid + 1;
            } else if (helper(matrix, k, mid, n) >= k) {
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }

    public static int helper(int[][] matrix, int k, int mid, int n) {
        int row = n - 1;
        int col = 0;
        int count = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] > mid) {
                row--;
            } else if (matrix[row][col] <= mid) {
                // if an element is less than mid that means all the element in that column above that element will also be less than mid
                count += row + 1;
                col++;
            }
        }

        return count;
    }
}
