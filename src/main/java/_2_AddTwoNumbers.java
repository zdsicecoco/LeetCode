/**
 * Created by zhangdongsheng on 2015/3/24.
 */
public class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        int c = 0;
        ListNode cur = dummy;
        while(l1 != null || l2 != null){
            int l1Val = 0;
            int l2Val = 0;
            if(l1 != null){
                l1Val = l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                l2Val = l2.val;
                l2 = l2.next;
            }
            int sum = l1Val + l2Val + c;
            int cursum = sum >= 10 ? sum - 10 : sum;
            c = sum >= 10 ? 1 : 0;
            cur.next = new ListNode(cursum);
            cur = cur.next;
        }
        if(c != 0)
            cur.next = new ListNode(1);
        return dummy.next;
    }
    public ListNode addTwoNumbersAccepted2(ListNode l1, ListNode l2){
        ListNode head = new ListNode(0);
        ListNode resCur = head;
        ListNode cursor1 = l1;
        ListNode cursor2 = l2;

        int carry = 0;
        int digit = 0;

        while(cursor1 != null || cursor2 != null){
            int sum = 0;
            int val1 = 0;
            int val2 = 0;
            if(cursor1 != null)
                val1 = cursor1.val;
            if(cursor2 != null)
                val2 = cursor2.val;
            sum = val1 + val2 + carry;
            if(sum > 9){
                carry = 1;
                digit = sum - 10;
            } else{
                carry = 0;
                digit = sum;
            }
            resCur.next = new ListNode(digit);

            resCur = resCur.next;
            if(cursor1 != null)
                cursor1 = cursor1.next;
            if(cursor2 != null)
                cursor2 = cursor2.next;
        }
        if(carry != 0)
            resCur.next = new ListNode(1);
        return head.next;
    }
    public ListNode addTwoNumbersAccepted1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        int len1 = 0;
        int len2 = 0;
        ListNode ll1 = l1;
        ListNode ll2 = l2;
        while (ll1 != null) {
            len1++;
            ll1 = ll1.next;
        }
        while (ll2 != null) {
            len2++;
            ll2 = ll2.next;
        }
        ll1 = l1;
        while (ll1.next != null) ll1 = ll1.next;
        ll2 = l2;
        while (ll2.next != null) ll2 = ll2.next;
        if (len1 <= len2) {
            for (int i = 0; i < len2 - len1; i++) {
                ll1.next = new ListNode(0);
                ll1 = ll1.next;
            }
        } else {
            for (int i = 0; i < len1 - len2; i++) {
                ll2.next = new ListNode(0);
                ll2 = ll2.next;
            }
        }
        ll1 = l1;
        ll2 = l2;
        int s2 = 0;
        int s1 = 0;
        int sum = 0;
        ListNode resultListNode = null;
        ListNode resultListNodeInit = null;
        sum = ll1.val + ll2.val + s2;
        if(sum >= 10) {
            s1 = sum - 10;
            s2 = 1;
        } else{
            s1 = sum;
            s2 = 0;
        }
        resultListNodeInit = new ListNode(s1);
        resultListNode = resultListNodeInit;
        while (ll1.next != null && ll2.next != null) {
            sum = ll1.next.val + ll2.next.val + s2;
            if(sum >= 10) {
                s1 = sum - 10;
                s2 = 1;
            } else{
                s1 = sum;
                s2 = 0;
            }
            resultListNode.next = new ListNode(s1);
            resultListNode = resultListNode.next;
            ll1 = ll1.next;
            ll2 = ll2.next;
        }
        if (s2 != 0) {
            resultListNode.next = new ListNode(s2);
        }
        return resultListNodeInit;
    }

    public ListNode addTwoNumbers_down(ListNode l1, ListNode l2) {
        ListNode init = null;
        ListNode resultListNode = null;
        int s2 = 0;
        int s1 = 0;
        int sum = 0;
        while (l1 != null && l2 != null) {
            sum = l1.val + l2.val + s2;
            s1 = sum % 10;
            if (init == null) {
                init = new ListNode(s1);
            } else if (init.next == null) {
                resultListNode = new ListNode(s1);
                init.next = resultListNode;
                resultListNode = resultListNode.next;
            } else {
                resultListNode = new ListNode(s1);
                resultListNode = resultListNode.next;
            }
            s2 = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null && l2 == null) {
            if (s2 != 0) {
                if (init.next == null) {
                    resultListNode = new ListNode(s2);
                    init.next = resultListNode;
                } else {
                    resultListNode = new ListNode(s2);
                }
            }
        } else {
            if (l1 != null) {
                while (l1 != null) {
                    sum = l1.val + s2;
                    s1 = sum % 10;
                    if (init == null) {
                        init = new ListNode(s1);
                    } else if (init.next == null) {
                        resultListNode = new ListNode(s1);
                        init.next = resultListNode;
                        resultListNode = resultListNode.next;
                    } else {
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
                    if (init == null) {
                        init = new ListNode(s1);
                    } else if (init.next == null) {
                        resultListNode = new ListNode(s1);
                        init.next = resultListNode;
                        resultListNode = resultListNode.next;
                    } else {
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
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
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
