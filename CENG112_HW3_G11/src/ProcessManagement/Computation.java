package ProcessManagement;
import java.util.Random;

// This class creates Computation type.

public class Computation implements Comparable<Computation>{
	
	private int id; //each computation has an unique id
	private IProcess process; // the process that makes computation request
	private int occupation; //// requested time for the computation
	private int priority; // Priority of the computation.
	
	public Computation(IProcess process,int id) {
		this.process = process;
		this.occupation = randOccupation();
		this.id = id;
		this.priority = process.getPriority();
	}
	
	//starts getters and setters
	public IProcess getProcess() {
		return this.process;
	}
	
	public int getOccupation() {
		return this.occupation;		
	}
	
	public int getPriority() {
		return this.priority;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int number) {
		this.id = number;
	}
	
	public void setOccupation(int number) {
		this.occupation = number;
	}
	
	public void setPriority(int number) {
		this.priority = number;
		
	}
	//ends getters and setters

	//return process id, process type and occupation time
	public String toString() {
		return "P"+getId()+","+process.getType()+","+getOccupation()+"ns";		
	}
	
	//return random occupation time between 1 and 10
	private int randOccupation() {
		Random rand = new Random();
		return (rand.nextInt(10))+1;
	}

	@Override
	//Compares priorities of computations.
	// Returns a positive number if this priority is bigger than the other, 0 if equals and a negative number if smaller than other.
	public int compareTo(Computation other) {
		return (getPriority() - other.getPriority());
	}
}
