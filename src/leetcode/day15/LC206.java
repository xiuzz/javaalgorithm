package leetcode.day15;
public class LC206 {
	public class ListNode {
	  int val;
	 ListNode next;
	ListNode() {}
   ListNode(int val) { 
	   this.val = val;
	   }
   ListNode(int val, ListNode next) { 
	this.val = val; this.next = next; 
	}
 }
/* public ListNode reverseList(ListNode head) {
      ListNode cur=head;
      ListNode pre=null;
      ListNode next=null;
      while(cur!=null) {
         next=cur.next;
         cur.next=pre;
         pre=cur;
         cur=next;
      }
      return pre;
   }*/
  public ListNode reverseList(ListNode head) {
	  if(head==null||head.next==null)return head;
	  ListNode cur=reverseList(head.next);
	  cur.next=head;
	  head.next=null;
	  return head;
  }	

}
