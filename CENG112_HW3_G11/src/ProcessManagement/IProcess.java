package ProcessManagement;

/* An interface for  Process.*/

public interface IProcess {
	
	/** Finds the type.
	 * @return the type according to the priority of the process as a String.  */
	String getType();
	
	/** Finds the priority
	* @return the priority of the process as an integer. */
	int getPriority();
	
	/** Gives information about the object.
	* @return the information of the process as a string.*/
	String toString();
	

}
