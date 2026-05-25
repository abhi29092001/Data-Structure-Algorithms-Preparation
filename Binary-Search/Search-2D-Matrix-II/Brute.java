// TC -> O(m * n)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 21;
        System.out.println(searchMatrix(matrix, target));
    }    

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Logic - 
        // traversing each and every element in the matrix

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
