package drone;

import java.util.ArrayList;

public class DroneManager {
	private ArrayList<Drone> drones = new ArrayList<>();
	private int numberOfDefaultDrones = 50;
	private int numberOfChineseDrones = 30;

	public DroneManager() {
		for (int i = 0; i < numberOfDefaultDrones; i += 2) {
			drones.add(new DefaultDrone(i + 1, 1));
			drones.add(new DefaultDrone(i + 2, 2));
		}
		for (int j = 0; j < numberOfChineseDrones; j += 2) {
			drones.add(new ChineseDrone(j + 1, 1));
			drones.add(new ChineseDrone(j + 2, 2));
		}

	}

	public boolean canDeliver(double distance, double weight) {
		String message = "Using drones: ";
		for (Drone drone : drones) {
			// todo available time
			if (drone.getBattery() >= distance * 2) {
				message += drone.getId() + " ";
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