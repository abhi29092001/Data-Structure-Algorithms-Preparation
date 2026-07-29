// TC -> O(m * logn)
// SC -> O(1)

public class Better {
    public static void main(String[] args) {
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 21;
        System.out.println(searchMatrix(matrix, target));
    }    

    public static boolean searchMatrix(int[][] matrix, int target) {
        // Logic-
        // we'll apply binary search on every row but before applying will check whether first element of row is smaller or not, if not then do row--
        // if first element is small then apply binary search

        int m = matrix.length;
        int n = matrix[0].length;
        int row = m - 1;

        while (row >= 0) {
            if (matrix[row][0] == target) {
                return true;
            } else if (matrix[row][0] < target) {
                int low = 0;
                int high = n - 1;

                while (low <= high) {
                    int mid = (low + high) / 2;

                    if (matrix[row][mid] == target) return true;
                    else if (matrix[row][mid] < target) low = mid + 1;
                    else high = mid - 1;
                }
            }

            row--;
        }

        return false;
    }    
}
