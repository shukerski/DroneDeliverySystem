package requests;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import drone.Drone;
import drone.DroneManager;
import main.TimeConversion;
import warehouse.Warehouse;
import warehouse.WarehouseManager;

public class RequestManager {

	private Queue<Request> requests;
	private DroneManager dm;
	private WarehouseManager wm;

	public RequestManager(WarehouseManager wm, DroneManager dm) {
		requests = new LinkedList<>();
		this.dm = dm;
		this.wm = wm;
	}

	public void addRequest(Request r) {
		requests.add(r);
	}

	public boolean hasRequests() {
		return requests.isEmpty();
	}

	public Request getRequest() {
		if (!requests.isEmpty()) {
			return requests.peek();
		}
		return null;
	}

	public void executeRequest(ArrayList<Drone> deliveryDrones, double distance, long dateTime, Warehouse w) {
		long eta = dateTime + (long) (distance) * 60;
		
		System.out.println("ETA: " + TimeConversion.convertToDate(eta * 1000));

		dm.updateDroneTimes(deliveryDrones, distance, dateTime);
		w.update(requests.peek());
		requests.poll();
	}

	public void executeSupply(Request r) {
		wm.supply(r);
		requests.poll();
	}

}
