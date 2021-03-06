package drone;

import java.util.ArrayList;

public class DroneManager {
	private ArrayList<Drone> drones = new ArrayList<>();
	private int numberOfDefaultDrones = 50;
	private int numberOfChineseDrones = 30;

	public DroneManager() {
		int i = 0;
		for (; i < numberOfDefaultDrones; i += 2) {
			drones.add(new DefaultDrone(i + 1, 1));
			drones.add(new DefaultDrone(i + 2, 2));
		}
		for (; i < numberOfDefaultDrones + numberOfChineseDrones; i += 2) {
			drones.add(new ChineseDrone(i + 1, 1));
			drones.add(new ChineseDrone(i + 2, 2));
		}

	}

	public ArrayList<Drone> getDeliveryDrones(double distance, double weight, long time, int warehouseID) {
		ArrayList<Drone> deliveryDrones = new ArrayList<>();
		for (Drone drone : drones) {
			if ((time > drone.getAvailableTime()) && (drone.getBattery() >= distance * 2)
					&& (drone.getWarehouseID() == warehouseID)) {
				deliveryDrones.add(drone);
				weight -= drone.getCapacity();
			}

			if (weight < 0) {
				return deliveryDrones;
			}
		}
		return null;
	}

	public void updateDroneTimes(ArrayList<Drone> deliveryDrones, double distance, long time) {
		for (Drone drone : deliveryDrones) {
			drone.setBattery(drone.getBattery() - (int) (distance * 2));
			drone.setAvailableTime(time + (long) (distance * 2) * 60 + drone.chargingTime());
			drone.setBattery(drone.getMaxBattery());
		}
	}

}