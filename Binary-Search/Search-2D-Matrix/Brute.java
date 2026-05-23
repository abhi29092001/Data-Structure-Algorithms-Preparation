// TC -> O(n * m)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }    

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Logic-
        // Simple brute force solution, just visiting each and every element and comparing with the target

        int m = matrix.length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
