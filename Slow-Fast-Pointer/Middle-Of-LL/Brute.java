// TC -> O(n) -  2 pass
// SC -> O(1)

class ListNode {
    int data;
    ListNode next;
    
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Brute {
    public static ListNode middleNode(ListNode head) {
        // Logic-
        // in 1st iteration find out length of LL
        // in 2nd iteration run loop until middle becomes 0 and return temp's next node, that is the middle node

        // edge case - if there's only one node
        if (head.next == null) {
            return head;
        }
        
        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int middle = len / 2;

        temp = head;
        while (middle-- > 0) {
            if (middle == 0) {
                break;
            } else {
                temp = temp.next;
            }
        }

        return temp.next;
    }
}
