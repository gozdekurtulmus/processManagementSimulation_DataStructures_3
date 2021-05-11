package ProcessManagement;

/* SystemManagement class keeps simulations,
 the simulations are connected to each other in a linked list fashion.
 */

public class SystemManagement {
    private Simulation simulation1;
    private Simulation simulation2;
    private Simulation simulation3;

    public SystemManagement(){
        simulation1 = new Simulation(1);
        simulation2 = new Simulation(2);
        simulation3 = new Simulation(3);
        simulation1.setNext(simulation2); //simulation2 linked to the simulation1
        simulation2.setNext(simulation3); //simulation3 linked to the simulation2

    }
    
    //Starts all simulations
    public void startSimulations(){
        while (simulation1 != null){  //simulation1 is not a null
            simulation1.startSimulation(); //then simulation1 starts
            simulation1 = simulation1.getNext();
        }

    }



}
