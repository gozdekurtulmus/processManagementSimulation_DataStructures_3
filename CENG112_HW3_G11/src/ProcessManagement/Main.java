package ProcessManagement;

/** This class has the main method of the Operating System Process Management Simulation. 
 * It calls SystemManagement class to start the simulation.
 *
 * @author Merve Malak     260201043
 * @author Gozde Kurtulmus 280201105
 */

public class Main {

	public static void main( String[] args) {
		SystemManagement systemManagement = new SystemManagement();
		systemManagement.startSimulations(); //starts the simulation.

	}
	
	
}
