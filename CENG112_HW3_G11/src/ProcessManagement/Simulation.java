package ProcessManagement;

/** This class executes the Simulation using the logic of Linked implementation. */ 

public class Simulation {
	private IPriorityQueue<Computation> queue; //queue of computations to be executed.
	private ListInterface<IProcess> processList; //List of processes requested.
	private int simNumber; // Simulation number
	private Simulation nextSimulation; // Link to the next simulation
	private int computationNumber; // Number of computations to be executed.
	

	public Simulation(int simNumber) {
		this.simNumber = simNumber;
		this.nextSimulation = null;
		this.processList =  new LinkedList<>();
		this.queue = new PriorityQueue<>();
	}
	
	//Starts and runs the necessary processes for simulation. 
	public void startSimulation() {
		decideComputationNumber(); //Look how many computations will be created
		fillProcessList(); // Create the requested process list.
		listToPriorityQueue(); // Convert the process list into an priority queue with type computations.
		System.out.println("Simulation Number: "+simNumber);
		printQueue(); //Print the elements in the queue.
		System.out.println();
		SimulationStatistics getAccess = new SimulationStatistics(this.queue);
		getAccess.giveStatistics(); //Report the statistics of the simulation.
	}

	
	//setter for nextSimulation
	public void setNext(Simulation sim) { 
		this.nextSimulation = sim;
	}
	//getter for nextSimulation
	public Simulation getNext() {
		return this.nextSimulation;
		
	}
	
	//Prints the queue to the console.
	private void printQueue() {
		System.out.print("Computation Queue: ");
		Computation[] temp = queue.toArray();
		for ( int i =0 ; i<temp.length; i++) {
			if(i==0) {System.out.print(temp[i].toString());}
			else {System.out.print(" <-"+temp[i].toString());}
		}
	}
	
	//Creates new processes and adds to the list.
	private void fillProcessList() {
		while(computationNumber>0) {
			IProcess process = new Process();
			processList.add(process);
			computationNumber--;
		}			
	}
	
	//Converts the process list into an Priority Queue with type Computations.
	private void listToPriorityQueue() {
		int index=1;
		while(!processList.isEmpty()) {
			Computation computation = new Computation (processList.remove(),index); // Convert the process into a Computation.
			queue.enqueue(computation); //add computation to the priority queue.
			index++; 
		}		
	}
	
	//Decide how many processes will be requested for the simulation.
	private void decideComputationNumber(){
		switch (simNumber) {
			case 1 -> computationNumber = 3;
			case 2 -> computationNumber = 5;
			case 3 -> computationNumber = 10;
		}
	}
}
