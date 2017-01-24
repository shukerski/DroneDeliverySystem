package requests;

import drone.DroneManager;
import warehouse.Warehouse;
import warehouse.WarehouseManager;

public class RequestManager {
	public static boolean canExecuteRequest(Request request, WarehouseManager wm, DroneManager dm) {
		Warehouse w = wm.checkWarehouses(request);
		double weight = 0, distance = 0;
		boolean canExecute = false;
		if(w != null) {
			distance = wm.calculateDistance(w, request.getX(), request.getY());
			weight = wm.calculateTotalWeight(w, request.getProductsToDeliver());
			canExecute = dm.canDeliver(distance, weight);
			if(canExecute) {
				w.update(request.getProductsToDeliver());
			}
		}
		return canExecute;
	}
		
	
}
