package warehouse;
import java.util.Map;

public class WarehouseManager implements WarehouseManagerInterface {

	private Warehouse warehouse;

	public WarehouseManager(Warehouse warehouse) {
		super();
		this.warehouse = warehouse;
	}

	@Override
	public Map<Integer, Integer> getAvailableProducts() {
		return warehouse.getProducts();
	}

	@Override
	public double calculateDistance(int targetX, int targetY) {
		return Math.sqrt(Math.pow((targetX - warehouse.getX()), 2))
				+ Math.sqrt(Math.pow((targetY - warehouse.getY()), 2));
	}

}
