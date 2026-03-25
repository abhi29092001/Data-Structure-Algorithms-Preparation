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
    public ListNode rotateRight(ListNode head, int k) {
        // Logic is Simple-
        // 1. if k is 0 that means 0 rotations...return head directly
        // 2. if k is not zero, claculate len of LL
        // 3. if k is divisible by len that means the LL will become exactly same as of starting one...return head directly
        // 4. if k is not zero and not divisible by len then, take out the non-rotated portion in separate array and rotated portion in separate array
        // 5. first create nodes from rotated array and then create nodes from non-rotated array and keep on joining them...at last return new head
        
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        if (k % len == 0) {
            return head;
        }

        int rotations = k % len;
        int nonRotatedLen = len - rotations;
        int[] nonRotated = new int[nonRotatedLen];
        int[] rotated = new int[rotations];
        int i = 0;
        int j = 0;

        temp = head;
        while (nonRotatedLen-- > 0) {
            nonRotated[i] = temp.val;
            temp = temp.next;
            i++;
        }

        while (temp != null) {
            rotated[j] = temp.val;
            temp = temp.next;
            j++;
        }

        i = 1;
        head = new ListNode(rotated[0]);
        temp = head;
        while (i < rotated.length) {
            ListNode node = new ListNode(rotated[i]);
            temp.next = node;
            temp = temp.next;
            i++;
        }

        i = 1;
        ListNode node = new ListNode(nonRotated[0]);
        temp.next = node;
        temp = temp.next;
        while (i < nonRotated.length) {
            node = new ListNode(nonRotated[i]);
            temp.next = node;
            temp = temp.next;
            i++;
        }

        return head;
    }    
}
