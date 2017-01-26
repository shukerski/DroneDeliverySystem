package main;

import java.util.ArrayList;

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
		
		Warehouse x = wm.checkWarehouses(req1);
		double distance = wm.calculateDistance(x, req1.getX(), req1.getY());
		double weight = wm.calculateTotalWeight(w, req1.getProductsToDeliver());
		//dm.getDeliveryDrones(distance, weight, time, x.getId());
		
		System.out.println(rm.canExecuteRequest());

	}
}
