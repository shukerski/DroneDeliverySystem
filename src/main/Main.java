package main;

import java.util.ArrayList;

import drone.Drone;
import drone.DroneManager;
import product.Product;
import requests.Request;
import requests.RequestManager;
import requests.RequestType;
import warehouse.Warehouse;
import warehouse.WarehouseManager;

public class Main {

	static String req = "delivery 4 2016-10-25 12:31 420,100 1 5 2 20";
	static String reqq = "delivery 5 2016-10-25 12:40 420,369 1 5 2 20";
	static String reqqq = "supply 1 2016-10-25 12:35 0,0 1 5";

	public static void main(String[] args) {

		Warehouse w = new Warehouse(1, 42, 42);
		w.addProduct(new Product(1, "Waffle", 1500), 6);
		w.addProduct(new Product(2, "Cola", 2), 50);

		Warehouse w2 = new Warehouse(2, 420, 420);
		w2.addProduct(new Product(1, "Waffle", 10), 20);
		w2.addProduct(new Product(2, "Cola", 2), 50);

		ArrayList<Warehouse> warehouses = new ArrayList<>();
		warehouses.add(w);
		warehouses.add(w2);

		WarehouseManager wm = new WarehouseManager(warehouses);
		DroneManager dm = new DroneManager();
		RequestManager rm = new RequestManager(wm, dm);

		Request req1 = InputParser.createRequest(req);
		Request req2 = InputParser.createRequest(reqq);
		Request req3 = InputParser.createRequest(reqqq);

		rm.addRequest(req1);
//		rm.addRequest(req3);
		rm.addRequest(req2);

		while (true) {
			Request currentReq = rm.getRequest();
			System.out.println();

			if (currentReq == null) {
				System.out.println("No more request to proccess");
				break;
			}

			if (currentReq.getType().equals(RequestType.SUPPLY)) {
				rm.executeSupply(currentReq);
				

			} else {
				Warehouse currentW = wm.checkWarehouses(currentReq);

				if (currentW != null) {
					double distance = wm.calculateDistance(currentW, currentReq.getX(), currentReq.getY());
					double weight = wm.calculateTotalWeight(currentW, currentReq.getProductsToDeliver());

					ArrayList<Drone> deliveryDrones = dm.getDeliveryDrones(distance, weight, currentReq.getDateTime(),
							currentW.getId());

					if (deliveryDrones != null) {
						String message = "Executing request from warehouse: ";
						message += currentW.getId();
						message += "\nStarting: " + currentReq.getDateTime();
						message += "\nUsing drones: ";
						
						
						for (Drone drone : deliveryDrones) {
							message += drone.getId() + " ";
						}
						System.out.println(message);

						rm.executeRequest(deliveryDrones, distance, currentReq.getDateTime(), currentW);
					
					} else {
						currentReq.setDateTime(currentReq.getDateTime() + 1000);
						try {
							System.out.println("Waiting..");
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						continue;
					}

				} else {
					try {
						System.out.println("Waiting..");
						Thread.sleep(1000000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					continue;
				}
			}
		}
	}
}
