// TC -> O(n * log m)
// SC -> O(1)

import java.util.*;

public class Optimal {
    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int k = 3;
        System.out.println(aggressiveCows(stalls, k));
    }   
    
    public static int aggressiveCows(int[] stalls, int k) {
        // Logic - 
        // 1. we have to maximise the min distance between any two cows
        // 2. first sort the stalls (It'll be easy if stalls are sorted)
        // 3. min dist will be 1 between any two cows and that is low
        // 4. max dist will be diff between first stall and last stall and that is high
        // 5. you have to make a guess for dist
        // 6. pass that guess to helper func
        // 7. helper func will place cows in stalls and check if the min dist is greater or equal to mid, if yes then cows will be incremented that means cow has been placed
        // 8. Atlast check if all cows placed or not and similarly return true or false based on the check
        // 9. if true is returned that means now we have to check right side but first store the mid
        // 10. if false then move to left side 

        int n = stalls.length;
        int result = -1;
        
        Arrays.sort(stalls);
        
        int low = 1;
        int high = stalls[n - 1] - stalls[0];
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (helper(stalls, n, mid, k)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        return result;
    }

    public static boolean helper(int[] stalls, int n, int mid, int k) {
        int cows = 1;
        int prevCow = stalls[0];
        
        for (int i = 1; i < n; i++) {
            if (stalls[i] - prevCow >= mid) {
                cows++;
                prevCow = stalls[i];
            }
        }
        
        if (cows >= k) {
            return true;
        } else {
            return false;
        }
    }
}
