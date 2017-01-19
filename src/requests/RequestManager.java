package requests;

import drone.DroneManager;
import warehouse.WarehouseManager;

public class RequestManager {
	public static boolean canExecuteRequest(Request request, WarehouseManager wm, DroneManager dm) {
		return wm.hasRequestedProducts(request.getProductsToDeliver()) && 
		   dm.canDeliver(wm.calculateDistance(request.getReqX(), request.getReqY()), wm.calculateTotalWeight(request.getProductsToDeliver()));
		
	}
		
	
}
