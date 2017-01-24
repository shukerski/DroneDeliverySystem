package warehouse;
import java.util.Map;

import product.Product;
import requests.Request;

public interface WarehouseManagerInterface {
	
	public Map<Integer, Product> getAvailableProducts(Warehouse w);
	public double calculateDistance(Warehouse w, int targetX , int targetY);
	public double calculateTotalWeight(Warehouse w, Map<Integer, Integer> productsToDeliver);
	public Warehouse checkWarehouses(Request r);
	public void supply(Request r);
	
	

}
