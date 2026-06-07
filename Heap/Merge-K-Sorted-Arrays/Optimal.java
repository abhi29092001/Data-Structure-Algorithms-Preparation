// TC -> O((m * n) * logm)
// SC -> O(m)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        int mat[][] = {{1, 3, 5, 7},
                {2, 4, 6, 8}, 
                {0, 9, 10, 11}};
        System.out.println(mergeArrays(mat));
    }   
    
    public static ArrayList<Integer> mergeArrays(int[][] mat) {
        // Logic-
        // we'll use heap coz we need min element from every sorted array
        // we'll put first element along with row and col of every row in heap to get minimum out of them and afterwards we'll increment column by 1 of those array is min is pushed to result array
        // we'll keep on doing this until the array is exhausted and finally when heap is empty
        // return the result array

        int m = mat.length;
        int n = mat[0].length;

        // O(m) - space
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        // O(m * n) - output space
        ArrayList<Integer> result = new ArrayList<>();
        
        // O(m) - time
        for (int row = 0; row < m; row++) {
            minHeap.add(new int[]{mat[row][0], row, 0});
        }
        
        // O((m * n) * logm) - time 
        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int value = top[0];
            int row = top[1];
            int col = top[2];
            result.add(value);
            col++;
            
            if (col < n) {
                minHeap.add(new int[]{mat[row][col], row, col});
            }
        }
        
        return result;
    }
}
