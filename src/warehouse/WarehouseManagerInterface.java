package warehouse;
import java.util.List;

import product.Product;

public interface WarehouseManagerInterface {
	
	public List<Product> getAvailableProducts();
	
	public double calculateDistance(int targetX , int targetY);
	

}
