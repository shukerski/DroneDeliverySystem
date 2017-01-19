package warehouse;
import java.util.Map;

public interface WarehouseManagerInterface {
	
	public Map<Integer, Integer> getAvailableProducts();
	
	public double calculateDistance(int targetX , int targetY);
	

}
