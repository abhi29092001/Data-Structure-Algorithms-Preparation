public class Optimal {
    public static void main(String[] args) {
        String s = "()))((";
        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {
        // Mimicing stack
        int n = s.length();

        // stack size will increase when there is opening ( and decrease when there is closing ) for that opening one
        int stackSize = 0;

        // mismatch will increase when there is closing ) and when stack size is 0(means there is no opening ( for closing one i.e. it is extra)
        int mismatch = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stackSize++;
            } else if (ch == ')' && stackSize > 0) {
                stackSize--;
            } else {
                mismatch++;
            }
        }

        return stackSize + mismatch;
    }    
}
