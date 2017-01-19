package drone;
import java.util.ArrayList;

public class DroneManager {
	public ArrayList<DefaultDrone> drones = new ArrayList<>();
	private int numberOfDrones = 50;
	
	
	public DroneManager() {
		for (int i = 0; i < numberOfDrones; i++) {
			drones.add(new DefaultDrone(i + 1));
		}
		
	}
	
	public boolean canDeliver(int distance, double weight) {
		String message = "Using drones: ";
		for (DefaultDrone drone : drones) {
			
			if (drone.getIsFlying() == false && drone.getBattery() >= distance * 2) {
				message += drone.getId() + ", ";
				weight -= drone.getCapacity();
			}
			
			if (weight < 0) {
				System.out.println(message);
				return true;
			}
		}
		return false;
	}
	
	

}
