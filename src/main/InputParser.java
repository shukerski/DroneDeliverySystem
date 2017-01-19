package main;

import java.util.HashMap;
import java.util.Map;

public abstract class InputParser {

	public static Request createRequest(String req) {
		System.out.println(req);
		String[] parts = req.split(" ");
		if (parts.length % 2 == 0) {
			throw new IllegalArgumentException("Wrong number of arguments");
		} else {

			try {

				int reqID = Integer.valueOf(parts[1]);

				String coordinates = parts[4];
				String[] coordParts = coordinates.split(",");
				int targetcoordX = Integer.valueOf(coordParts[0]);
				int targetcoordY = Integer.valueOf(coordParts[1]);

				Map<Integer, Integer> products = new HashMap<>();

				for (int i = 5; i < parts.length - 1; i += 2) {
					products.put(Integer.valueOf(parts[i]), Integer.valueOf(Integer.valueOf((parts[i + 1]))));
				}

				return new Request(reqID, targetcoordX, targetcoordY, products);
			} catch (Exception e) {
				throw new IllegalArgumentException("Wrong request input");
			}

		}

	}

}
