/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Question-1
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Node three=new Node(1,null);
        Node two=new Node(2,three);
        Node one=new Node(3,two);

        Node three1=new Node(1,null);
        Node two1=new Node(2,three1);
        Node one1=new Node(3,two1);

        Question-1 object=new Question-1();

        int result=object.GetNumber(one) + object.GetNumber(one1);
        System.out.println(result);
       	Node finalObject=object.SplitNumber(result);
       	//printing the final result
        object.Display(finalObject);
    }
    
    //get the int value of the number
    public int GetNumber(Node head) {
        int sum=0;
        int multiplier=1;
        while(head!=null) {
            sum = sum + (multiplier*head.data);
            multiplier= multiplier*10;
            head=head.next;
        }
        return sum;
    }
    
    //split int Linked List
    public Node SplitNumber(int data){
        String s= (new Integer(data)).toString();
        Node prev = null;
        Node head = null;
        for(Character c : s.toCharArray()) {
        	System.out.println(c);
        	Node obj=new Node(Character.getNumericValue(c),null);
            if(prev == null) {
                prev = obj;    //only for first time
                head = prev;
            } else {
                prev.next = obj;
                prev = obj;
            }
        }
        return head;
    }
    
   public void Display(Node head){
        while(head!=null){
            System.out.println(head.data);
            head=head.next;
        }
    }

    public Node ReverseLinkedList(Node head){
        Node current=head;
        Node previous=null;
        Node next=null;

        while(current!=null){
            previous=current.next;
            current.next=null;
            previous.next=current;
            current=previous;
        }

        return previous;
    }
}

class Node {
    int data;
    Node next;

    public Node(int d,Node n){
        data=d;
        next=n;
    }
}