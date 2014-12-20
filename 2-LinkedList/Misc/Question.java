/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Question {
    public ListNode reverse(ListNode pre, ListNode next) {
      ListNode last = pre.next;
      ListNode cur = last.next;
      
      while(cur != next) {
        last.next = cur.next;
        cur.next = pre.next;
        pre.next = cur;
        
        cur = last.next;
      }
      return last;
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
       if (head ==null || k==1){
            return head;
        }
        
        ListNode dummy =new ListNode (0);
        dummy.next=head;
        int cnt = 0;
        ListNode pre=dummy;
        while(head != null) {
          cnt++;
          if(cnt % k == 0) {
            pre = reverse(pre, head.next);
            head = pre.next;
          }
          else
            head = head.next;
        }
        return dummy.next;
    }
    public ListNode reverseList(ListNode head) {
      if(head == null) return null;
      int count = 1; //since initially we are considering the head next node
      ListNode prevNode, cur, nextNode;
      prevNode = head;
      cur = prevNode.next;
      nextNode = cur;
      while(nextNode != null) {
         nextNode = nextNode.next;
         cur.next = prevNode;
         prevNode = cur;
         if(nextNode != null) {
             cur = nextNode;
         }
         count++;
      }
      head.next = nextNode;
      return prevNode;
    }
    public static void main (String[] args) throws java.lang.Exception {
      Question program = new Question();
      ListNode one = new ListNode(1);
      ListNode two = new ListNode(2);
      ListNode three = new ListNode(3);
      ListNode four = new ListNode(4);
      ListNode five = new ListNode(5);
      one.next = two;
      two.next = three;
      three.next = four;
      four.next = five;
      System.out.println(one.forwardList());
      // while(NextNode != null) {
      //    System.out.print(NextNode.val + ":");
      //    NextNode = NextNode.next;
      // }
      ListNode result = program.reverseList(one);
      
      System.out.println(result.forwardList());
        
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
      val = x;
      next = null;
    }
    String forwardList() {
      if(next == null) return ((Integer) val).toString();
      else return val + ":" + next.forwardList();
    }
}