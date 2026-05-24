// TC -> O(logm * n)
// SC -> O(1)
 
public class Optimal {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }            

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Logic-
        // first find out the resultant row using binary search and then also apply binary search on that row
        // 1. Apply binary search on 1st column coz its in monotonic form and we need to find the element which is lesser than target (last occurence) coz target will be in that row only
        // 2. once got the row then apply binary search on that row to find out the target
        // 3. if its there return true otherwise false

        int m = matrix.length;
        int n = matrix[0].length;
        int row = -1;
        int low = 0;
        int high = m - 1;
        
        // Applying binary search on the 1st column to find out the row
        while (low <= high) {
            int mid = (low + high) / 2;

            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] <= target) {
                row = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // edge case, if there is only one element and that too is not target then, needs to handle that case otherwise row=-1 will be used in below logic
        if (row == -1) {
            return false;
        }

        // finding the target in the its respective row
        low = 0;
        high = n - 1;

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
