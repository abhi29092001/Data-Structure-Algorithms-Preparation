// TC -> O(n) - 2 pass
// SC -> O(1)

class ListNode {
    int data;
    ListNode next;
    
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Better {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Logic-
        // Find len of LL first
        // take one more pointer prev, keep it at null
        // then run loop till u reach nth node by decreasing len at every node
        // at each iteration prev will remain one step behind
        // when len will become equal to n, that means prev will be one node behind
        // change the prev's node pointer and connect it to temp's next node, this will make sure that temp node will be removed from the LL, break out of loop
        // finally return head

        // if only one node is there
        if (head.next == null) {
            return null;
        }

        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        // if first node will be deleted
        if (len == n) {
            return head.next;
        }

        temp = head;
        ListNode prev = null;
        while (len > 0) {
            if (len == n) {
                prev.next = temp.next;
                break;
            }
            prev = temp;
            temp = temp.next;
            len--;
        }

        return head;
    }
}
