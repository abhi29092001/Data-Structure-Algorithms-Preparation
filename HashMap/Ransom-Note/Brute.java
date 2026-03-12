// TC -> O(n * m) 
// SC -> O(m)

public class Brute {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        System.out.println(canConstruct(ransomNote, magazine));
    }
    
    public static boolean canConstruct(String ransomNote, String magazine) {
        // we'll use sb instead of magazine
        StringBuilder sb = new StringBuilder(magazine);
        int n = ransomNote.length();

        // if ransomNote length is greater then sb/magazine then the ans is false;
        if (n > sb.length()) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            // boolean for tracking char
            boolean charFound = false;

            int m = sb.length();

            for (int j = 0; j < m; j++) {

                // if char matches then delete that char from sb so that the exact same char can't be used(can be used only once)
                if (ransomNote.charAt(i) == sb.charAt(j)) {
                    charFound = true;
                    sb.deleteCharAt(j);
                    break;
                }
            }

            // if some ransomNote char is not present in sb/magazine then ans is sure shot false
            if (!charFound) {
                return false;
            }
        }

        return true;
    }
}
