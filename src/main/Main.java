package main;

import java.util.ArrayList;

import drone.Drone;
import drone.DroneManager;
import product.Product;
import requests.Request;
import requests.RequestManager;
import warehouse.Warehouse;
import warehouse.WarehouseManager;

public class Main {

	static String req = "delivery 4 2016-10-25 12:31 420,369 1 5 2 20";

	public static void main(String[] args) {

		Warehouse w = new Warehouse(42, 42);
		w.addProduct(new Product(1, "Waffle", 1), 20);
		w.addProduct(new Product(2, "Cola", 2), 50);

		Warehouse w2 = new Warehouse(420, 420);
		w2.addProduct(new Product(1, "Waffle", 1), 20);
		w2.addProduct(new Product(2, "Cola", 2), 50);

		ArrayList<Warehouse> warehouses = new ArrayList<>();
		warehouses.add(w);
		warehouses.add(w2);

		WarehouseManager wm = new WarehouseManager(warehouses);
		DroneManager dm = new DroneManager();
		RequestManager rm = new RequestManager(wm, dm);

		Request req1 = InputParser.createRequest(req);
		Request req2 = InputParser.createRequest(req);

		rm.addRequest(req1);
		rm.addRequest(req2);

		while (true) {
			Request currentReq = rm.getRequest();
			Warehouse currentW = wm.checkWarehouses(currentReq);

			if (currentW != null) {
				double distance = wm.calculateDistance(currentW, currentReq.getX(), currentReq.getY());
				double weight = wm.calculateTotalWeight(currentW, currentReq.getProductsToDeliver());

				ArrayList<Drone> deliveryDrones = dm.getDeliveryDrones(distance, weight, currentReq.getDateTime(),
						currentW.getId());

				if (deliveryDrones != null) {
					rm.executeRequest(deliveryDrones,distance, currentReq.getDateTime(),currentW);
				} else {
					currentReq.setDateTime(currentReq.getDateTime() + 6000000);
				}

			} else {
				try {
					//Wait 10 minutes
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}

		}
	}
}
