// TC -> O(n + logm)
// SC -> O(1)

public class Better {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }    

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Logic-
        // first find out the resultant row and then apply binary search on that row

        int m = matrix.length;
        int n = matrix[0].length;
        int resRow = -1;
        
        for (int i = 0; i < m; i++) {
            if (matrix[i][n - 1] == target) {
                return true;
            } else if (matrix[i][n - 1] > target) {
                resRow = i;
                break;
            }
        }

        // if target not lies in any 1D array that means it doesn't exist
        if (resRow == -1) {
            return false;
        }

        int row = resRow;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }    
}
