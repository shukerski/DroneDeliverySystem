package warehouse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import product.Product;
import requests.Request;

public class WarehouseManager implements WarehouseManagerInterface {

	private ArrayList<Warehouse> warehouses;

	public WarehouseManager(ArrayList<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	@Override
	public Map<Integer, Product> getAvailableProducts(Warehouse w) {
		return w.getProducts();
	}

	@Override
	public double calculateDistance(Warehouse w, int targetX, int targetY) {
		return Math.sqrt(Math.pow((targetX - w.getX()), 2))
				+ Math.sqrt(Math.pow((targetY - w.getY()), 2));
	}

	@Override
	public double calculateTotalWeight(Warehouse w, Map<Integer, Integer> productsToDeliver) {
		double weight = 0;
		for (Integer id : productsToDeliver.keySet()) {
			weight += w.getProducts().get(id).getWeight() * productsToDeliver.get(id);
		}
		return weight;
	}

	@Override
	/**
	 * Checks availability of the requested product in every warehouse.
	 * 
	 * @return Warehouse id
	 */
	public Warehouse checkWarehouses(Request r) {
		for(Warehouse w: warehouses) {
			if(w.checkAvailability(r.getProductsToDeliver())) {
				return w;
			}
		}
		return null;
	}

	@Override
	public void supply(Request r) {
		int warehouseId = r.getId();
		for (Warehouse warehouse : warehouses) {
			if(warehouse.getId() == warehouseId) {
				warehouse.update(r);
			}
		}
	}
	
	
	

}
