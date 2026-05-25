// TC -> O(m + n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 21;
        System.out.println(searchMatrix(matrix, target));
    }    

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Logic - 
        // In this we cannot use typical binary search because last element of row is not lesser then the first element of next row so due to this we cannot treat whole array as 1D array and apply binary search on it. 

        // So, will take either bottom left element or top right element coz bottom left element is the last element of col 1 and first element of last row. In the similar way, top right element is the last element of row 0 and first element of last column. So, we can cut either row or column depending on whether target is greater or smaller...this will keep going on until we find target

        int m = matrix.length;
        int n = matrix[0].length;

        int row = m - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }

        return false;
    }    
}
