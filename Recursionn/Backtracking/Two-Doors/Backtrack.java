// TC -> O(2^n)
// SC -> O(n)-recursive stack space + O(n)-arraylist

import java.util.*;

public class Backtrack {
    public static void main(String[] args) {
        String[] doors = {"d1", "d2"};
        findAllPaths(doors, doors.length, 0, new ArrayList<>());
    }    

    public static void findAllPaths(String[] doors, int n, int i, ArrayList<String> diary) {
        if (i == n) {
            System.out.println(diary.toString());
            return;
        }

        // only two choices are there either take left or right-generate all paths

        // left
        diary.add("left");
        findAllPaths(doors, n, i + 1, diary);
        diary.remove(diary.size() - 1);

        // right
        diary.add("right");
        findAllPaths(doors, n, i + 1, diary);
        diary.remove(diary.size() - 1);
    }
}
