// TC -> O(n * m)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        int k = 2;
        System.out.println(findPages(arr, k));
    }

    public static int findPages(int[] arr, int k) {
        // Logic-
        // Brute Force
        // 1. put low equals max element of arr and high will be sum of arr
        // 2. loop through each element
        // 3. once you got the element based on which we can distribute books to every student then simply store the result and break out of the loop coz each and every element next to that element will be eligible for the same and we want to find the min. element for this 

        int n = arr.length;
        
        // if students are more and books are less
        if (k > n) {
            return -1;
        }
        
        int low = 0;
        int high = 0;
        int result = -1;
        
        for (int i = 0; i < n; i++) {
            low = Math.max(arr[i], low);
            high += arr[i];
        }
        
        for (int i = low; i <= high; i++) {    
            if (helper(arr, n, i, k)) {
                result = i;
                break;
            }
        }
        
        return result;
    }
    
    public static boolean helper(int[] arr, int n, int pages, int k) {
        int countStud = 1;
        int pagesCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (pagesCount + arr[i] <= pages) {
                pagesCount += arr[i];
            } else {
                countStud++;
                pagesCount = arr[i];
                
                if (countStud > k) {
                    return false;
                }
            }
        }
        
        return true;
    }    
}
