package requests;

import java.util.Queue;

import drone.DroneManager;
import warehouse.Warehouse;
import warehouse.WarehouseManager;

public class RequestManager {

	private Queue<Request> requests;
	private DroneManager dm;
	private WarehouseManager wm;

	public RequestManager(WarehouseManager wm, DroneManager dm) {
		this.dm = dm;
		this.wm = wm;
	}

	public void addRequest(Request r) {
		requests.add(r);
	}

	public boolean hasRequests() {
		return requests.isEmpty();
	}
	
	public void executeRequest() {
		
	}

	public boolean canExecuteRequest() {

		Request request = requests.poll();

		Warehouse w = wm.checkWarehouses(request);
		double weight = 0, distance = 0;
		boolean canExecute = false;
		if (w != null) {
			distance = wm.calculateDistance(w, request.getX(), request.getY());
			weight = wm.calculateTotalWeight(w, request.getProductsToDeliver());
			canExecute = dm.canDeliver(distance, weight);
			if (canExecute) {
				w.update(request);
			}
		}

		return canExecute;
	}

}
