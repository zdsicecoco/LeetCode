/**
 * Created by zhangdongsheng on 2015/3/24.
 */
public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode init = null;
        ListNode resultListNode = null;
        int s2 = 0;
        int s1 = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + s2;
            s1 = sum % 10;
            if(init == null){
                init = new ListNode(s1);
                init.next = resultListNode;
            } else{
                resultListNode = new ListNode(s1);
                resultListNode = resultListNode.next;
            }
            s2 = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null) {
            if (s2 != 0) {
                resultListNode = new ListNode(s2);
            }
        } else {
            if (l1 != null) {
                while (l1 != null) {
                    sum = l1.val + s2;
                    s1 = sum % 10;
                    if(init == null){
                        init = new ListNode(s1);
                        resultListNode = init.next;
                    } else{
                        resultListNode = new ListNode(s1);
                        resultListNode = resultListNode.next;
                    }
                    s2 = sum / 10;
                    l1 = l1.next;
                }
                if (s2 != 0) resultListNode = new ListNode(s2);
            } else {
                while (l2 != null) {
                    sum = l2.val + s2;
                    s1 = sum % 10;
                    resultListNode = new ListNode(s1);
                    if(init == null){
                        init = new ListNode(s1);
                        resultListNode = init.next;
                    } else{
                        resultListNode = new ListNode(s1);
                        resultListNode = resultListNode.next;
                    }
                    s2 = sum / 10;
                    l2 = l2.next;
                }
                if (s2 != 0) resultListNode = new ListNode(s2);
            }
        }
        return init;
    }

    public static void main(String[] args) {
        _2_AddTwoNumbers obj = new _2_AddTwoNumbers();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode listNode = obj.addTwoNumbers(l1, l2);
        do {
            System.out.println(listNode.val);
            listNode = listNode.next;
        } while (listNode != null);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
