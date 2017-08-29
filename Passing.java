// CS1020 (AY2014/5 Semester 4) - Lab 6
//
// Name: Xie Peiyi
// Matric. No.: A0141123B
// Lab group: 1
//
// Write the program description below.
// It is mandatory to write program description at the top of every program.
// Pass a ball in the right or left direction in amongst a group of player arranged
// in a circle. Report the person holding the ball after each pass. Eliminate a player
// if he has received the balls a pre-determined number of times.
//
//
//

import java.util.*;

// You will need a player class to represent a player
class Player {
	private String name;
	private int numBall;
	private int limit;
	private boolean reached;

	public Player(String name, int limit){
		this.name = name;
		this.limit = limit;
	}

	public void receiveBall(){
		numBall++;
		if(numBall == limit)
			reached = true;
	}
	public String toString(){
		return name;
	}
	public boolean reaches(){
		return reached;
	}

}

// This ListNode class is provided for you if you are going to implement the linked list yourself
// You can modify it in anyway you deem fit.
// If you don't need it remove it.
class ListNode {
	private Player element;
	private ListNode next;

	/* constructors */
	public ListNode(Player item) {
		element = item;
		next = null;
	}

	public ListNode(Player item, ListNode n) {
		element = item;
		next = n;
	}

	/* get the next ListNode */
	public ListNode getNext() {
		return this.next;
	}

	/* get the element of the ListNode */
	public Player getElement() {
		return this.element;
	}

	public void setNext(ListNode item) {
		this.next = item;
	}

	public void setElement(Player item) {
		this.element = item;
	}
}

// This skeleton LinkedList class is given to you if you choose to implement the linked list yourself
// You can modify it in anyway you deem fit.
// If you don't need it remove it.
class LinkedList {
	private ListNode _head;
	private int _size;
	private ListNode _tail;

	public void addFirst(Player item){
		_size++;
		_head = new ListNode(item, _head);
		if (_tail == null)
			_tail = _head;
		_tail.setNext(_head);
	}
	
	
	public void addAfter(ListNode current, Player item) {
		_size++;
		ListNode added = new ListNode(item);
		if(current == _tail){
			_tail.setNext(added);
			added.setNext(_head);
			_tail = added;
		}
		else{
			ListNode temp = current.getNext();
			current.setNext(added);
			added.setNext(temp);
		}
	}

    // this method is incomplete ! Modify it to make it work if you choose to implement this method
	public Player removeAfter(ListNode current) throws NoSuchElementException {
		Player temp;
		if (current != null) {
			_size--;
			if(current == _tail){
				temp = _head.getElement();
				_head = _head.getNext();
				_tail.setNext(_head);
			}else if(current.getNext() == _tail){
				temp = _tail.getElement();
				_tail = current;
				_tail.setNext(_head);
			}else{
				temp = current.getNext().getElement();
				ListNode next = current.getNext().getNext();
				current.setNext(next);
			}

		}
		else
			throw new NoSuchElementException("No next node to remove");
		return temp;

	}
	public ListNode getTail(){return _tail;}
	public ListNode getHead(){return _head;}
	public int getSize(){return _size;}
	public void display(){
		ListNode temp = _head;
		for(int i = 0; i < _size; i++){
			System.out.println(temp.getElement());
			temp = temp.getNext();
		}
		System.out.println();
	}
}


// Implement the Passing class
public class Passing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int ops = sc.nextInt();
		int numK = sc.nextInt();
		LinkedList list = new LinkedList();
		list.addFirst(new Player(sc.next(), numK));
		ListNode pointer = list.getTail(); 
		for(int i = 1; i < number; i++){
			list.addAfter(pointer, new Player(sc.next(), numK));
			pointer = list.getTail();
		}
		pointer = list.getHead();
		for (int i = 0; i < ops; i++){
			int numPass = sc.nextInt();
			String direction = sc.next();
			numPass %= list.getSize();
			Player holding = pointer.getElement();
			ListNode tempStart = pointer;
			
			if (direction.equals("R")){
				pointer = rightPass(pointer, numPass);
				holding = pointer.getElement();
			}else if (direction.equals("L")){
				pointer = rightPass(pointer, list.getSize() - numPass);
				holding = pointer.getElement();
			}
			System.out.println(holding);
			if(holding.reaches()){
				pointer = eliminate(pointer, list, direction);
			}else{
				pointer = swap(tempStart, pointer);

			}
		}
	}

		


	// Pass the balls in the right direction, return the ListNode with the player holding the ball.
	public static ListNode rightPass(ListNode pointer, int numPass){
		for(int i = 0 ; i < numPass; i++){
			pointer = pointer.getNext();
		}
		pointer.getElement().receiveBall();
		return pointer;
	}
	// Remove the listnode with player who has reached the limit k, return the listnode
	// with the player holding the ball afther the removed player. 
	public static ListNode eliminate(ListNode pointer, LinkedList list, String direction){
		ListNode nextPointerRight = pointer.getNext();
		
		ListNode temp = pointer;
		for(int i = 0; i < list.getSize() - 1; i++)
			temp = temp.getNext();
		ListNode nextPointerLeft = temp;

		list.removeAfter(temp);
		if(direction.equals("R")) return nextPointerRight;
		else return nextPointerLeft;
	}
	// Swap two players
	public static ListNode swap(ListNode last, ListNode current){
		Player temp = current.getElement();
		current.setElement(last.getElement());
		last.setElement(temp);
		return last;
	}
}
