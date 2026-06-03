// TC -> O(n logn)
// SC -> O(n)

import java.util.*;

class Pair {
    int[] first;
    int second;

    Pair(int[] first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Brute {
    public static void main(String[] args) {
        int[][] points = {{1,3},{-2,2}};
        int k = 1;
        System.out.println(kClosest(points, k));
    }   
    
    public static int[][] kClosest(int[][] points, int k) {
        // Logic-
        // created pair class in which first element will be arr point itself and second will be dist from that point to origin
        // loop through arr to calculate dist and then put point and dist in list
        // after that sort the list wrt to dist
        // loop till k to take out k elements from list
        // return arr in the end

        int n = points.length;

        // space - O(n)
        List<Pair> list = new ArrayList<>();

        // O(n) - time 
        for (int i = 0; i < n; i++) {
            int dist = (points[i][0] * points[i][0])+ (points[i][1] * points[i][1]);

            list.add(new Pair(points[i], dist));
        }

        // sorting - O(n logn) - time
        Collections.sort(list, (a, b) -> Integer.compare(a.second, b.second));

        // space - O(k)
        int[][] result = new int[k][2];

        // time - O(k)
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).first;
        }

        return result;
    }
}
