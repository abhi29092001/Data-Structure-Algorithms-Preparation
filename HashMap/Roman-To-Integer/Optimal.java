// TC -> O(n)
// SC -> O(1)

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        String s = "LXIII";
        System.out.println();
    }    

    public int romanToInt(String s) {
        // Logic-
        // we need hashmap to store key-value pair i.e. roman to integer mapping
        // roman numerals are bigger to smaller in pattern from left to right
        // if we encounter numerals like IV, CD,...
        // subtract smaller one and add bigger one to capture correct roman to integer conversion
        // once loop ends return sum 

        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int sum = 0;

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (i < n - 1 && map.get(ch) < map.get(s.charAt(i + 1))) {
                sum -= map.get(ch);
            } else {
                sum += map.get(ch);
            }
        }

        return sum;
    }
}
