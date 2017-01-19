import java.util.List;

public interface WarehouseManagerInterface {
	
	public List<Product> getAvailableProducts();
	
	public double calculateDistance(int targetX , int targetY);
	

}
