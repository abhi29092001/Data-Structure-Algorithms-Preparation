public class Brute {
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

        // divide freq of 'l' and 'o' by 2 because 2l and 2o is required in 1 balloon instance
        freq['l' - 'a'] /= 2;
        freq['o' - 'a'] /= 2;

        // initialized mincount with 0th index of freq i.e. 'a'. If freq of 'a' is 0 then return 0 or mincount
        int minCount = freq[0];
        if (minCount == 0) {
            return minCount;
        }

        // looping on string again but only checking for b,a,l,o,n and getting their freq to find min among them
        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);

            if ((ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') && freq[ch - 'a'] < minCount) {
                minCount = freq[ch - 'a'];
            }
        }

        return minCount;
    }
}
