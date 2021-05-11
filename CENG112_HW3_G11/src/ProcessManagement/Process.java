package ProcessManagement;

import java.util.Random;

/** This class creates a Process. */

public class Process implements IProcess {
	private String type; // Type of the process
	private int priority;//Priority of the process.
	
	public Process() {
		this.priority = randomPriority(); //Assign a random priority
		this.type = priorityType(priority); // Convert the priority into a string of type.
	}
		
	//Beginning of the setter and getters.
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public void setPriority(int number) {
		this.priority = number;
	}//End of the getter and setter methods.
	
	//Give the information about the process.
	public String toString() {
		return "Type:"+this.type+"Priority: "+this.priority;
	}
	
	//Give a random priority between 1 and 3.
	private int randomPriority() {
		Random rand = new Random();
		return (rand.nextInt(3))+1;
	}
	
	//Convert the given number to type.
	private String priorityType (int priorityNumber) {
        return switch(priorityNumber) {
        case 1 -> "High";
        case 2 -> "Normal";
        case 3 -> "Low";
        default -> null;
        };
    }
	
}
