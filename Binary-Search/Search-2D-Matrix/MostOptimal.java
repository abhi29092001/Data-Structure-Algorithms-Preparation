// TC -> O(logm * n)
// SC -> O(1)
 
public class MostOptimal {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }            

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Logic-
        // treat whole array as 1D array and find out low and high according to that only, after that find mid and convert mid to row and col. Afterwards, its just simple binary search

        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = (m * n) - 1;  // index according to 1D array
        
        // Applying binary search to find out the element by treating matrix as 1D array
        while (low <= high) {
            int mid = (low + high) / 2;
            int row = mid / n;
            int col = mid % n;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    } 
}
