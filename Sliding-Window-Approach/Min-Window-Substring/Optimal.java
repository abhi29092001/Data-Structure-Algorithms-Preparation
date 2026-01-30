// TC -> O(m+n)
// SC -> O(1)

public class Optimal {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution(s, t));
    }
    
    public static String solution(String s, String t) {
        int m = s.length();
        int n = t.length();
        int low = 0;
        int resLen = Integer.MAX_VALUE;
        int start = 0;
        int[] freqS = new int[256];
        int[] freqT = new int[256];

        for (int i = 0; i < n; i++) {
            freqT[t.charAt(i)]++;
        }

        for (int high = 0; high < m; high++) {
            freqS[s.charAt(high)]++;

            while (compare(freqS, freqT)) {
                int len = high - low + 1;
                if (resLen > len) {
                    resLen = len;
                    start = low;
                }
                freqS[s.charAt(low)]--;
                low++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(start, start + resLen);
    }

    public static boolean compare(int[] freqS, int[] freqT) {
        for (int i = 0; i < 256; i++) {
            if (freqS[i] < freqT[i]) {
                return false;
            }
        }
        return true;
    }
}
