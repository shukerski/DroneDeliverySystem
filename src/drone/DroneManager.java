package drone;
import java.util.ArrayList;

public class DroneManager {
	private ArrayList<DefaultDrone> drones;
	private int numberOfDrones = 50;
	
	
	public DroneManager() {
		for (int i = 0; i < numberOfDrones; i++) {
			drones.add(new DefaultDrone(i));
		}
		
	}
	
	
	
	
	

}
