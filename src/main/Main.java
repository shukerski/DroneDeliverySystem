package main;

import java.util.Scanner;

import drone.DroneManager;

public class Main {
	
	public static void main(String[] args) {
		DroneManager dm = new DroneManager();
		dm.drones.get(2).setIsFlying(true);
		System.out.println(dm.canDeliver(900, 1499));
		System.out.println("Super fast drone delivery system!");

		Scanner input = new Scanner(System.in);

		String req = "delivery 4 2016-10-25 12:31 420,369 23 5 54 20";

		Request request = InputParser.createRequest(req);
		
		System.out.println(request.getId());
		System.out.println(request.getReqX());
		System.out.println(request.getReqY());
		System.out.println(request.getProductsToDeliver());
	}
}
