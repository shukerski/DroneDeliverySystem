package main;

import java.util.ArrayList;
import java.util.Scanner;

import drone.DroneManager;
import product.Product;
import requests.Request;
import requests.RequestManager;
import warehouse.Warehouse;
import warehouse.WarehouseManager;


public class Main {
	
	public static void main(String[] args) {
		DroneManager dm = new DroneManager();
		dm.drones.get(2).setIsFlying(true);
//		System.out.println(dm.canDeliver(900, 1499));
//		System.out.println("Super fast drone delivery system!");

		Scanner input = new Scanner(System.in);

		String req = "delivery 4 2016-10-25 12:31 420,369 1 5 2 20";

		Request request = InputParser.createRequest(req);
		
//		System.out.println(request.getId());
//		System.out.println(request.getReqX());
//		System.out.println(request.getReqY());
//		System.out.println(request.getProductsToDeliver());
		
		Warehouse w = new Warehouse(42, 42);
		Warehouse w2 = new Warehouse(420, 420);
		ArrayList<Warehouse> warehouses = new ArrayList<>();
		warehouses.add(w);
		warehouses.add(w2);
		w.addProduct(new Product(1, "Waffle", 1), 20);
		w2.addProduct(new Product(2, "Cola", 2), 50);
		
		WarehouseManager wm = new WarehouseManager(warehouses);
		
		
		System.out.println(RequestManager.canExecuteRequest(request, wm, dm));
	}
}
