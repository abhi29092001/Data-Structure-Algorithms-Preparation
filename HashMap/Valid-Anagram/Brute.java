// TC -> O(n * logn)
// SC -> O(n)


public class Brute {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }    

    public static boolean isAnagram(String s, String t) {
        // Logic-
        // if lengths are not same then return false
        // sorted both strings after converting into char arrays
        // if at some point both chars are diff return false
        // if loop ends then return true

        int n = t.length();

        if (s.length() != n) {
            return false;
        }

        char[] arr1 = t.toCharArray();
        char[] arr2 = s.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        for (int i = 0; i < n; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }
}
