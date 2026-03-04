// TC -> O(n^2)
// SC -> O(1)

public class Brute {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(dailyTemperatures(temperatures));
    }
    
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] resArray = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            boolean warmerTempFound = false;

            for (int j = i + 1; j < n; j++) {
                count++;

                if (temperatures[j] > temperatures[i]) {
                    resArray[i] = count;
                    warmerTempFound = true;
                    break;
                }
            }

            if (!warmerTempFound) {
                resArray[i] = 0;
            }
        }

        return resArray;
    }
}
