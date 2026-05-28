// TC -> O((m + n) * log(m * n))
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int m = 3;
        int n = 3;
        int k = 5;
        System.out.println(findKthNumber(m, n, k));
    }   
    
    public static int findKthNumber(int m, int n, int k) {
        // Logic -
        // Matrix is a sorted matrix and the kth smallest element definitely will be in the range of min element and max element of matrix. Take a guess means find out mid and check in matrix that how much element are smaller than mid. if count is greater than k then store that element and move to the left side otherwise move to the right side.

        // This is similar to kth smallest element in sorted matrix but in this ques matrix is not given so we have to calculate multiplication on the go and make decision accordingly whether the element is smaller or greater

        int low = 1; // min element of matrix
        int high = m * n; // max element of matrix
        int result = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            int ans = helper(m, mid, n);

            if (ans < k) {
                low = mid + 1;
            } else if (ans >= k) {
                result = mid;
                high = mid - 1;
            }
        }

        return result;
    }    

    public static int helper(int m, int mid, int n) {
        // row, col - taking bottom left element
        int row = m;
        int col = 1;
        int count = 0;

        while (row >= 1 && col <= n) {
            if (row * col > mid) {
                row--;
            } else if (row * col <= mid) {
                // if an element is less than mid that means all the element in that column above that element will also be less than mid
                count += row;
                col++;
            }
        }

        return count;
    }
}
