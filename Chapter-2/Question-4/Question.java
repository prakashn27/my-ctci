import java.util.*;
import java.lang.*;
import java.io.*;

// package Question2_4;

class Question {
	int a, b, sum, carry = 0;	
	LinkedListNode head,first,second;
    public LinkedListNode reverseSum(LinkedListNode num1, LinkedListNode num2) {
    	while(num1 != null || num2 != null || carry == 1) {	//added carry for cases considering the carry on last bit
    		if(num1 != null) {
    			a = num1.data;
    			num1 = num1.next;
    		}
    		else
    			a = 0;
    		if(num2 != null) {
    			b = num2.data;
    			num2 = num2.next;
    		}
    		else 
    			b = 0;
    		
    		sum = a + b + carry;
    		carry = sum/10;	//quotient
    		sum = sum % 10;	//remainder
    		
    		first = new LinkedListNode(sum, null, null);
    		if(second == null) {
    			second = first;
    			head = second;	//assigned the head for the first time
    		}
    		else {
    			second.setNext(first);
    			first.setPrev(second);
    			second = first;
    		}
    	}
    	return head;
    }
    public static void main(String[] args) {
    	Question program = new Question();
        LinkedListNode first = new LinkedListNode(9, null, null);
        LinkedListNode num1 = first;
        for(int i = 8; i > 6 ; i--) {
            LinkedListNode sec = new LinkedListNode(9, null, null);
            first.setNext(sec);
            sec.setPrev(first);
            first = sec;
        }
        System.out.println(num1.printNode());
       	first = new LinkedListNode(9, null, null);
        LinkedListNode num2 = first;
        for(int i = 8; i > 6 ; i--) {
            LinkedListNode sec = new LinkedListNode(9, null, null);
            first.setNext(sec);
            sec.setPrev(first);
            first = sec;
        }
        System.out.println(num2.printNode());
        LinkedListNode result = program.reverseSum(num1, num2);
        System.out.println(result.printNode());
    }
}
class LinkedListNode {
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
    
    // public static void main(String[] args) {
    // 	LinkedListNode first = new LinkedListNode(10, null, null);
    // 	LinkedListNode sec = new LinkedListNode(20, null, null);
    // 	first.setNext(sec);
    // 	System.out.println(first.printNode());
    // }
}