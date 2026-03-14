// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        String text = "loonbalxballpoon";
        System.out.println(maxNumberOfBalloons(text));
    }
    
    public static int maxNumberOfBalloons(String text) {
        int n = text.length();

        // array to store the frequencies
        int[] freq = new int[26];

        // Storing freq
        for (int i = 0; i < n; i++) {
            freq[text.charAt(i) - 'a']++;
        }

        // 1. Finding min between b and a
        // 2. Finding min b/w l and o
        // 3. Finding min b/w min of l/o and n
        // 4. Finding min b/w b/a and l/o/n
        // 5. return the answer(balloon instances depends on min count) 
        return Math.min( 
                    Math.min(freq['b' - 'a'], freq['a' - 'a']),
                    Math.min(
                        Math.min(freq['l' - 'a'] / 2, freq['o' - 'a'] / 2),
                            freq['n' - 'a']
                    )
                );
    }
}
