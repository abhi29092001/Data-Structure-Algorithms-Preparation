// TC -> O(n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(solution(s, k));
    }

    public static int solution(String s, int k) {
        int low = 0;
        int maxLen = 0;
        int n = s.length();
        int[] freq = new int[26];

        for (int high = 0; high < n; high++) {
            freq[s.charAt(high) - 'A']++;
            int len = high - low + 1;
            int maxFreq = findMax(freq);
            int diff = len - maxFreq;

            while (diff > k) {
                freq[s.charAt(low) - 'A']--;
                low++;
                len = high - low + 1;
                maxFreq = findMax(freq);
                diff = len - maxFreq;
            }

            maxLen = Math.max(len, maxLen);
        } 

        return maxLen;
    }

    public static int findMax(int[] freq) {
        int maxi = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxi) {
                maxi = freq[i];
            }
        }

        return maxi;
    }
}
