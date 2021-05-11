package ProcessManagement;

/** This class implements a linked list */

public class LinkedList<T> implements ListInterface<T> {
	
    private Node firstNode; // Reference to first node of chain
    private Node lastNode;
    private int size; //the number of elements in the chain
    
    public LinkedList(){
        this.firstNode = null;
        this.lastNode = null;
        this.size = 0; //at the beginning chain is empty
    }
    
    private class Node{ //inner class
        private T data; // data variable keeps the data in the node
        private Node next; // Link to the next node
        
        private Node(T data){
            this.data = data;
            this.next = null;
        }
        
        private Node(T data, Node next){
            this.data = data;
            this.next = next;
        }
        
        // starts the getters and setters methods
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
        }
        //ends the getters and setters methods
    } //end Node class

    //returns the node in the specified index
    private Node getNode(int givenPosition){
        assert (firstNode != null) && (0 <= givenPosition) && (givenPosition <= size);
        Node currentNode = firstNode;
        for (int i = 0; i < givenPosition; i++) { //traverse the chain to locate the desired Node
            currentNode = currentNode.getNextNode();
        }
        assert currentNode != null;
        return currentNode;

    }
    
    @Override
    //adds the newEntry to the end of the chain
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        if (isEmpty()){ // add to end of nonempty list
            firstNode = newNode;
        }
        else{
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
        size++; //update number of the chain
    }


    @Override
    //adds the new entry to the chain at the specified index
    public void add(int newPosition, T newEntry) {
        assert ((newPosition >= 0) && (newPosition <= size));
        Node newNode = new Node(newEntry);
        if (isEmpty()){  // add to end of nonempty list
            firstNode = newNode;
            lastNode = newNode;
        }
        else if (newPosition == 0){
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        }
        else if (newPosition == size){
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
        else{
            Node nodeBefore = getNode(newPosition - 1);
            Node nodeAfter = nodeBefore.getNextNode();
            newNode.setNextNode(nodeAfter);
            nodeBefore.setNextNode(newNode);
        }
        size++; //update number of the chain
    }


    @Override
    //Removes and returns the entry at the position givenPosition
    public T remove(int givenPosition) {
        T removeNodeData; //return value
        assert ((givenPosition >= 0) && (givenPosition <= size-1));
        assert !isEmpty();
        if (givenPosition == 0){  //remove first entry
            removeNodeData = firstNode.getData();
            firstNode = firstNode.getNextNode(); //removed entry
            if (size == 1){
                lastNode = null;
            }
        }
        else{ //not first entry
            Node nodeBefore = getNode(givenPosition-1);
            Node nodeToRemove = nodeBefore.getNextNode();
            Node nodeAfter = nodeToRemove.getNextNode();
            nodeBefore.setNextNode(nodeAfter);
            removeNodeData = nodeToRemove.getData();
            if (givenPosition == size){
                lastNode = nodeBefore;
            }
        }
        size--; //update number of the chain
        return removeNodeData;
    }

    @Override
    //remove first entry
    public T remove() {
        T removeNodeData;
        assert !isEmpty();
        removeNodeData = firstNode.getData();
        firstNode = firstNode.getNextNode();
        if(size == 1){
            lastNode = null;
        }
        size--; //update number of the chain
        return removeNodeData;
    }

    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    @Override
    //returns the data in the specified index
    public T getEntry(int givenPosition) {
        assert ((givenPosition >= 0) && (givenPosition <= size-1));
        assert !isEmpty();
        return getNode(givenPosition).getData();
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getLength() {
        return this.size;
    }
}
