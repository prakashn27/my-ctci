/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

class Question {
	Boolean isPalindrome(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		
		while(fast != null && fast.next != null) {    //use fast and slow to get to the middle entry
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if(fast != null) { //case of middle element
			slow = slow.next;
		}
		
		while(!stack.isEmpty()) {
			int top = stack.pop();
			if(top != slow.data) return false;
			slow = slow.next;
		}
		return true;
	}
	public static void main(String[] args) {
		Question pgm = new Question();
		LinkedListNode first = new LinkedListNode(30, null, null); 
    	LinkedListNode sec = new LinkedListNode(20, null, null); 
    	first.setNext(sec); 
    	LinkedListNode third = new LinkedListNode(20, null, null); 
    	sec.setNext(third);
    	LinkedListNode four = new LinkedListNode(30, null, null); 
    	third.setNext(four);
    	if(pgm.isPalindrome(first)) {
    		System.out.println("palindrome");
    	} else {
    		System.out.println("NO palindrome");
    	}
	}	
}
/* Name of the class has to be "Main" only if the class is public. */
class LinkedListNode { 
    public LinkedListNode getNthElement(int n){
        int count = 1;	//because we need to take in account of the first element
        if(this == null)
            return null; 
        LinkedListNode first = this;
        while(count < n) {
            count++;
            first = first.next;
        } 
        return first;
    } 
    int data;
    LinkedListNode next;
    LinkedListNode prev;
     
    public LinkedListNode() { 
    } 
     
    public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
        data = d;
        this.setNext(n);
        this.setPrev(p);
    } 
    //sets the next node 
    public void setNext(LinkedListNode n) {
        next = n;
        if(n != null && n.prev != this) {	//n.prev is checked in order stop adding the node recursively
            n.setPrev(this);
        } 
    } 
    //sets the prev node 
    public void setPrev(LinkedListNode p) {
        prev = p;
        if(p != null && p.next != this) { 	//p.next is to imply termination
            this.setNext(p);
        } 
    } 
     
    public String printNode() {
        if(next != null) {
            return data + ":" + next.printNode();
        } 
        else 
            return ((Integer) data).toString();
    } 
} 