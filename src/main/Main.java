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
	
	static String req = "delivery 4 2016-10-25 12:31 420,369 1 5 2 20";
	
	public static void main(String[] args) {
		
		Warehouse w = new Warehouse(42, 42);
		w.addProduct(new Product(1, "Waffle", 1), 20);
		w.addProduct(new Product(2, "Cola", 2), 50);

		Warehouse w2 = new Warehouse(420,420);
		w2.addProduct(new Product(1, "Waffle", 1), 20);
		w2.addProduct(new Product(2, "Cola", 2), 50);
		
		ArrayList<Warehouse> warehouses = new ArrayList<>();
		warehouses.add(w);
		warehouses.add(w2);
		
		WarehouseManager wm = new WarehouseManager(warehouses);
		DroneManager dm = new DroneManager();
		

		Request request = InputParser.createRequest(req);

		
		
		System.out.println(RequestManager.canExecuteRequest(request, wm, dm));
	}
}
