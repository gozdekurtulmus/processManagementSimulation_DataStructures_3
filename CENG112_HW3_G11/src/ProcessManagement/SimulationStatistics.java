package ProcessManagement;

/** This class calculates the statistics of the simulation. */

public class SimulationStatistics {

	private IPriorityQueue<Computation> queue; //Given queue that statistics will be calculated from.
	private int highComputationCount; //Number of High type computations.
	private int normalComputationCount; //Number of Normal type computations.
	private int lowComputationCount; //Number of Low type computations.
	private double highWaitingTime; // Waiting time for High type computations.(Except the last High priority computation.)
	private double high2;	//Total time High computations used.
	private double normalWaitingTime; // Waiting time for Normal type computations.(Except the last Normal priority computation.)
	private double normal2;  //Total time Normal computations used.
	private double lowWaitingTime; // Waiting time for Low type computations. (Except the last Low priority computation.)
	private double totalWaitingTime; //Total time all computations used.
	
	public SimulationStatistics(IPriorityQueue<Computation> queue) {
		this.queue = queue; 

		this.highComputationCount = 0;
		this.normalComputationCount = 0;
		this.lowComputationCount = 0;
		this.highWaitingTime = 0;
		this.normalWaitingTime = 0;
		this.lowWaitingTime = 0;	
		this.totalWaitingTime = 0;
	}
	
	
	//Prints the report of the Simulation.
	public void giveStatistics() {
		executeQueue();
		int totalCount = highComputationCount + normalComputationCount + lowComputationCount;
		System.out.println("Total number of computations : "+ totalCount +"\n");	
		
		System.out.println("Total waiting time: " + totalWaitingTime);
		System.out.println("Average waiting time: " + (totalWaitingTime/totalCount) +"\n" );
		
		System.out.println("Total number of computations for High: " + highComputationCount);
		System.out.println("Total number of computations for Normal: " + normalComputationCount);
		System.out.println("Total number of computations for Low:" + lowComputationCount + "\n");

		if( highComputationCount == 0 ) { //If there are no High priority computations to be calculated.
			System.out.println("Total waiting time for High: 0");	
			System.out.println("Average waiting time for High: 0");}
		else {
			System.out.println("Total waiting time for High: " + highWaitingTime);	
			System.out.println("Average waiting time for High: " + (highWaitingTime / highComputationCount)+ "\n");}
			System.out.println();
		
		if ( normalComputationCount == 0) {  //If there are no Normal priority computations to be calculated.
			System.out.println("Total waiting time for Normal: 0");
			System.out.println("Average waiting time for Normal: 0");}		
		else {
			System.out.println("Total waiting time for Normal: " + (normalWaitingTime+high2));
			System.out.println("Average waiting time for Normal: " + ((normalWaitingTime+high2) / normalComputationCount)+ "\n");}
		
		if( lowComputationCount== 0) {  //If there are no Low priority computations to be calculated.
			System.out.println("Total waiting time for Low: 0");
			System.out.println("Average waiting time for Low: 0");}
		else {
			System.out.println("Total waiting time for Low: " + (high2+normal2+lowWaitingTime));
			System.out.println("Average waiting time for Low: " + ((lowWaitingTime+high2 + normal2) / lowComputationCount)+ "\n\n");}
		System.out.println();
	}
	
	
	//Counts the necessary numbers 
	public void executeQueue() {
		while(!queue.isEmpty()) {
			Computation computation = queue.dequeue(); //Executes every element in the queue.
			
			if ( !queue.isEmpty()) { 
				totalWaitingTime += computation.getOccupation(); //Counts the total waiting time of all computations.
			}
			
				switch(computation.getPriority()) {
				case 1:
					highComputationCount += 1; //Counts the number of High priority computations.
					if (!queue.isEmpty()&& queue.peek().getPriority() == computation.getPriority()) { 
						highWaitingTime += computation.getOccupation();			//Calculates the waiting time of High except the last High priority computation.
					}
					high2 = highWaitingTime + computation.getOccupation(); // Calculates all waiting time needed for the High priority computations..
					break;
					
				case 2:
					normalComputationCount += 1;	//Counts the number of Normal priority computations.	
					if(!queue.isEmpty() && queue.peek().getPriority() == computation.getPriority()) {
						normalWaitingTime += computation.getOccupation();   //Calculates the waiting time of Normal except the last Normal priority computation.
					}
					 normal2 = normalWaitingTime + computation.getOccupation();  // Calculates all waiting time needed for the Normal priority computations.
					break;
					
				case 3:
					lowComputationCount += 1;    //Counts the number of Low priority computations.	
					if(!queue.isEmpty() && queue.peek().getPriority() == computation.getPriority()) {		
						lowWaitingTime += computation.getOccupation();		//Calculates the waiting time of Low except the last Low priority computation.
					}
					break;
				}
			}
		}	
	}
	
	
	
	


