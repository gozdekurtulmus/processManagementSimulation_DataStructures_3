package ProcessManagement; 

/*An interface for a Priority Queue.*/

public interface IPriorityQueue<T extends Comparable<? super T>> {

	
    /** Adds new entry to the queue with respect to its priority
    @param: newEntry. An object to be added.
     */
	void enqueue(T newEntry);
	
    /** Removes and returns entry at the front of the queue.
    @return The object at the front of the queue.
     */
	T dequeue();
	
    /** Looks at the entry at the front of the queue.
    @return The object at the front of the queue.
     */
	T peek();
	
    /** Detects whether the queue is empty.
    @return True if the queue is empty, or false otherwise.
     */
	boolean isEmpty();
	
    /** Finds the number of objects in the queue
    @return The number of objects
     */
	int getSize();

    /** Turns the queue into an array.
    @return The queue as an array.
     */
	T[] toArray();
	
	/** Removes all entries from the queue. */
	void clear();
	
	
}
