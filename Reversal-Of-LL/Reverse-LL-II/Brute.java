// TC -> O(n)
// SC -> O(n)

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Brute {
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        // Logic is Simple-
        // 1. first count length of LL
        // 2. create array of LL size
        // 3. take nodes val and put it into array
        // 4. put left right pointers in array and swap the node values
        // 5. now put the values back into LL

        int len = 0;
        ListNode temp = head;
        
        // finding len of LL
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int[] nodes = new int[len];

        // putting node values in array
        int index = 0;
        temp = head;
        while (temp != null) {
            nodes[index] = temp.val;
            temp = temp.next;
            index++;
        }

        // swapping node values from left to right
        int l = left - 1;
        int r = right - 1;
        while (l <= r) {
            int swapVar = nodes[l];
            nodes[l] = nodes[r];
            nodes[r] = swapVar;
            l++;
            r--;
        }

        // Putting node values back into LL
        index = 0;
        temp = head;
        while (temp != null) {
            temp.val = nodes[index];
            temp = temp.next;
            index++;
        }

        return head;
    }
}
