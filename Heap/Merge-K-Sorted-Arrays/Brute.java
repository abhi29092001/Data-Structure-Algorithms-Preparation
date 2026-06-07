// TC -> O(m * n * log(m * n))
// SC -> O(m * n)

import java.util.*;

public class Brute {
    public static void main(String[] args) {
        int mat[][] = {{1, 3, 5, 7},
                {2, 4, 6, 8}, 
                {0, 9, 10, 11}};
        System.out.println(mergeArrays(mat));
    }   
    
    public static ArrayList<Integer> mergeArrays(int[][] mat) {
        // Logic-
        // create an arraylist and put all the elements in the arraylist and after that sort it and finally return it

        int m = mat.length;
        int n = mat[0].length;
        
        // O(m * n) - space
        ArrayList<Integer> result = new ArrayList<>();
        
        // O(m * n) - time
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result.add(mat[i][j]);
            }
        }
        
        // O(m*n log(m*n)) - time
        Collections.sort(result);
        
        return result;
    }
}
