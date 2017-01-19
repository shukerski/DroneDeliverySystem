package main;
import java.util.Scanner;

import drone.DroneManager;

public class Main {

	public static void main(String[] args) {
		DroneManager dm = new DroneManager();
		dm.drones.get(2).setIsFlying(true);
		System.out.println(dm.canDeliver(900, 1200));
		System.out.println("Super fast drone delivery system!");

		Scanner input = new Scanner(System.in);

		String req = input.nextLine();

		Request request = new Request(req);
		
	}
		

}
