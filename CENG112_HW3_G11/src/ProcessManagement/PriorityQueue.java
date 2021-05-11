package ProcessManagement;

/** This class implements a priority queue using a chain of linked nodes. */

public class PriorityQueue<T extends Comparable<T>> implements IPriorityQueue<T> {
	private Node firstNode; //The object at the front of the queue.
	private int size; //length of the queue

	public PriorityQueue() {
		this.firstNode = null;
		this.size = 0;
	}
	
	private class Node{ //inner class
        private T data;  //keeps the data in the node
        private Node next; // Link to the next node

        private Node(T data){
            this.data = data;
            this.next = null;
        }
        
        private Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
        
        //Beginning of the getter and setter methods
        private T getData(){
            return this.data;
        }
        private void setData(T newData){
            this.data = newData;
        }
        private Node getNextNode(){
            return this.next;
        }
        private void setNextNode(Node newNode){
            this.next = newNode;
        } //End of the getter and setter methods.
        
	}//end of the inner class.
	
	
	//Adds the new entry to the queue with respect to its priority
	public void enqueue(T newEntry) {
		Node newNode = new Node(newEntry);
		if (isEmpty()){ //if the queue is empty, add to the front.
            firstNode = newNode;
        }
        else{
        	// In this queue implementation, head of queue has lesser priority than newNode.
        	if(newEntry.compareTo(firstNode.data) < 0 ) { //If the newNode's priority is less than the front, add it to the front.
        		newNode.next = firstNode;
        		firstNode = newNode;
        	}
        	else {
        		Node traverse = firstNode;
        		while(traverse.next != null && traverse.next.data.compareTo(newNode.data) < 0) { //Search till the newNode's priority is equal or less than the next.
        			traverse = traverse.next;
        		}
        		newNode.next = traverse.next;
        		traverse.next = newNode;
        	}
        }	
        size++; //Increase size
	}

	// Return the object at the front of the queue.
	public T dequeue() {
		T temp = firstNode.data;
		firstNode = firstNode.next;
		size--; 
		return temp;		
	}

	//Convert the queue into an array.
	public T[] toArray(){
		@SuppressWarnings("unchecked")
        T[] array = (T[]) new Computation[size];
        Node temp = firstNode;
        int count =0;
        while (temp!= null){
            array[count] = temp.data;
            temp = temp.getNextNode();
            count++;
        }
        return array;
    }

	//Returns object at the front of the queue without taking it out of the queue.
	public T peek() {
		return firstNode.data;
	}
	
	//Clear the queue.
	public void clear() {
		firstNode = null;	
	}
	
	//Get the size of the queue.
	public int getSize() {
		return this.size;
	}	
	
	//Look if the queue is empty.
	public boolean isEmpty() {
		return this.size==0;
	}
	

}
	


