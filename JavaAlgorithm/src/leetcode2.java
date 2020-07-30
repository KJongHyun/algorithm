public class leetcode2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
//        ListNode l3 = new ListNode(3);
        l1.next = l2;
//        l2.next = l3;

        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(8);
//        ListNode r3 = new ListNode(4);
        r1.next = r2;
//        r2.next = r3;

        addTwoNumbers(l1, null);
    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode currentNode = answer;
        int carry = 0;
        while(true) {
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum / 10;
            int currentVal = sum % 10;
            currentNode.val = currentVal;
            if (l1 == null && l2 == null) {
                if (carry == 0) {
                    break;
                } else {
                    currentNode.next = new ListNode();
                    currentNode.next.val = carry;
                    break;
                }
            }

            currentNode.next = new ListNode();
            currentNode = currentNode.next;
        }
        return answer;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}



