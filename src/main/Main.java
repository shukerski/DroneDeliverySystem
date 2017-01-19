package main;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		String req = "delivery 4 2016-10-25 12:31 420,369 23 5 54 20";

		Request request = InputParser.createRequest(req);
		
		System.out.println(request.getId());
		System.out.println(request.getReqX());
		System.out.println(request.getReqY());
		System.out.println(request.getProductsToDeliver());
	}
}
