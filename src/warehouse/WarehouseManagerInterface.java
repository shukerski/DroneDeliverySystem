package warehouse;
import java.util.Map;

import product.Product;

public interface WarehouseManagerInterface {
	
	public Map<Integer, Product> getAvailableProducts();
	
	public double calculateDistance(int targetX , int targetY);
	public boolean hasRequestedProducts(Map<Integer, Integer> productsToDeliver);
	public double calculateTotalWeight(Map<Integer, Integer> productsToDeliver);
	

}
