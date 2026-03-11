// TC -> O(n ^ 2)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        String s = "abbccdda";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        int n = s.length();

        for (int i = 0; i < n; i++) {
            // boolean variable to keep a track of whether character is unique or not
            boolean uniqueFound = true;

            for (int j = 0; j < n; j++) {
                // for every character inner loop will run from starting to properly check
                // take this test case - abcda
                // if we don't run loop from starting in every iteration then code will fail
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    uniqueFound = false;
                    break;
                }
            }

            // if we don't find any duplicate then return ith index, otherwise -1
            if (uniqueFound) {
                return i;
            }
        }

        return -1;
    }
}
