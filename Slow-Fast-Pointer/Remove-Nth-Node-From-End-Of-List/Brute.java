// TC -> O(n)
// SC -> O(n)

class ListNode {
    int data;
    ListNode next;
    
    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Brute {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Logic-
        // Find len of LL first
        // then skip the nth node by decreasing len at every node
        // if its not nth node put that node's val into array 
        // create new LL based on values we get
        // return head of new LL

        if (head.next == null) {
            return null;
        }

        ListNode temp = head;
        int len = 0;

        while (temp != null) {
            len++;
            temp = temp.next;
        }

        int[] nodes = new int[len - 1];
        int index = 0;
        temp = head;
        while (len > 0) {
            if (len != n) {
                nodes[index] = temp.data;
                index++;
            }
            temp = temp.next;
            len--;
        }

        ListNode dummyNode = new ListNode(0);
        ListNode curr = dummyNode;
        for (int i = 0; i < nodes.length; i++) {
            ListNode newNode = new ListNode(nodes[i]);
            curr.next = newNode;
            curr = curr.next;
        }

        return dummyNode.next;
    }
}
