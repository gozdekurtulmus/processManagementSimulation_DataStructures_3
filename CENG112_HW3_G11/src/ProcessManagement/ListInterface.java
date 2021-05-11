package ProcessManagement;

/**An interface for the ADT List.
  Entries in a list have positions that begin with 0.*/


public interface ListInterface<T> {
	
	
    /** Adds a new entry to the end of the list.
    @param newEntry: The object to be added as a new entry.*/
    void add(T newEntry);

    /**Adds a new entry at a specified position within the list.
    @param newPosition: An integer that specifies he desired position of the new entry.
    @param newEntry: The object to be added as a new entry.*/
    void add(int newPosition, T newEntry);

    /**Removes the entry t a given position from this list.
    *@param givenPosition: An integer that indicates the position of the entry to be removed.
    *@return A reference to the removed entry.*/
    T remove(int givenPosition);

    /**Removes the first entry in the list.
    @return A reference to the removed entry.*/
    T remove();

    /**Removes all entries from the list.*/
    void clear();

    /**Retrieves the entry at the given position in this list.
    @param givenPosition: An integer that indicates the position of the desired entry.
    @return A reference to the indicated entry.*/
    T getEntry(int givenPosition);

    /**Sees whether this list is empty.
    @return True if the list is empty, or false if not.*/
    boolean isEmpty();

    /**Gets the length of this list.
    @return The integer number of entries currently in the list.*/
    int getLength();
}
