// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        int[] a = {3,-4, 2,-3,-1, 7,-5};
        System.out.println(minsubArray(a));
    }

    public static int minsubArray(int[] a) {
        int n = a.length;
        int best = a[0];
        int ans = a[0];
        
        for (int i = 1; i < n; i++) {
            int val1 = best + a[i];
            int val2 = a[i];
            
            best = Math.min(val1, val2);
            ans = Math.min(ans, best);
        }
        
        return ans;
    }
}
