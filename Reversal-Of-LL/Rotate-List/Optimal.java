// TC -> O(n)
// SC -> O(1)

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Optimal {
    public ListNode rotateRight(ListNode head, int k) {
        // Logic is Simple-
        // 1. if k is 0 that means 0 rotations...return head directly
        // 2. if k is not zero, claculate len of LL
        // 3. if k is divisible by len that means the LL will become exactly same as of starting one...return head directly
        // 4. if k is not zero and not divisible by len then, calculate number of actual rotations and take 3 pointers temp,beforeRotated,newHead
        // 5. run loop till last node, and put beforeRotated on that node which is just before rotated node and newHead to first rotated node and temp will remain on last node
        // 6. change pointers accordingly
        // 7. return newHead

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
        ListNode beforeRotated = null;
        ListNode newHead = null;
        temp = head;

        while (temp.next != null) {
            if (len == rotations + 1) {
                beforeRotated = temp;
                newHead = temp.next;
            }

            temp = temp.next;
            len--;
        }

        beforeRotated.next = null;
        temp.next = head;

        return newHead;
    }    
}
