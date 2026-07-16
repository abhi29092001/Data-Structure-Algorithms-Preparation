// TC -> O(m + n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));
    }    

    public static boolean isAnagram(String s, String t) {
        // Logic-
        // if lengths are not same then return false
        // mapped char to freq for string s
        // loop over string t and decrement freq of char if it exists in hashmap, if not return false directly
        // when loop ends return true

        int m = s.length();
        int n = t.length();

        if (m != n) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < m; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            char ch = t.charAt(i);

            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) - 1);

                if (map.get(ch) == 0) {
                    map.remove(ch);
                }
            } else {
                return false;
            }
        }

        return true;
    }    
}
