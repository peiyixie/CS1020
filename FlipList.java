// CS1020 (AY2014/5 Semester 4) - Lab 5
//
// Name: Xie Peiyi
// Matric. No.: A0141123B
// Lab group: 1
//
// Write the program description below.
// To flip a given list at given indexes.
//
//
//
//
//

import java.util.*;

class ListNode {
	private ListNode next;
	private String element;

	/* constructors */
	public ListNode(String item) { this(item, null); }

	public ListNode(String item, ListNode n) { 
		element = item; 
		next = n;
	}

	/* get the next ListNode */
	public ListNode getNext() { return next; }

	/* get the element of the ListNode */
	public String getElement() { return element; }

	/* set the next reference */
	public void setNext(ListNode n) { next = n; }

	public void setElement(String item) { element = item; }


	// you may add more methods to ListNode as you deem fit
}

class LinkedList {
	private ListNode head;	
	private int numNode;
	 
	public void initialiseLinkedList(int size) {
		//initialise the linked list here
		head = new ListNode("A");
		ListNode temp = head;
		for(int i = 1; i < size; i++){
			temp.setNext(new ListNode(Character.toString((char)(65+i))));
			temp = temp.getNext();
		}
		numNode = size;
	}
	
	public void manipulate(int startingIndex, int endingIndex) {
		if (startingIndex >= numNode) return;
		if (endingIndex >= numNode) endingIndex = numNode - 1;
		ListNode p1 = head;
		int index = 0;
		for(index = 0; index < startingIndex; index++){
			p1 = p1.getNext();
		}
		int dist = endingIndex - startingIndex;
		for(int i = 0; i < ((endingIndex - startingIndex)/2)+1 ; i++){
			ListNode p2 = p1;
			for(int j = 0; j < dist; j++) p2 = p2.getNext();
			String temp = p1.getElement();
			p1.setElement(p2.getElement());
			p2.setElement(temp);
			dist -= 2;
			p1 = p1.getNext();
		}

	}

	public String print() {
		//for printing the answer
		String result = head.getElement();
		ListNode temp = head.getNext();
		for(int i = 1; i < numNode; i++){
			result += temp.getElement();
			temp = temp.getNext();
		}
		return result;
	}

}

public class FlipList {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		LinkedList list = new LinkedList();
		int num = scan.nextInt();
		int numOps = scan.nextInt();
		list.initialiseLinkedList(num);
		int startingIndex, endingIndex;
		for(int i = 0; i < numOps; i++){
			list.manipulate(scan.nextInt(), scan.nextInt());
		}
		
		// your code here
		System.out.println(list.print());
	}
}
