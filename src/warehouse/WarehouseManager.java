package warehouse;
import java.util.Map;

import product.Product;

public class WarehouseManager implements WarehouseManagerInterface {

	private Warehouse warehouse;

	public WarehouseManager(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	@Override
	public Map<Integer, Product> getAvailableProducts() {
		return warehouse.getProducts();
	}

	@Override
	public double calculateDistance(int targetX, int targetY) {
		return Math.sqrt(Math.pow((targetX - warehouse.getX()), 2))
				+ Math.sqrt(Math.pow((targetY - warehouse.getY()), 2));
	}

	@Override
	public double calculateTotalWeight(Map<Integer, Integer> productsToDeliver) {
		double weight = 0;
		boolean hasAvailable = hasRequestedProducts(productsToDeliver);
		if(hasAvailable) {
			for (Integer id : productsToDeliver.keySet()) {
				weight += warehouse.getProducts().get(id).getWeight() * productsToDeliver.get(id);
			}
		}
		return weight;
	}

	@Override
	public boolean hasRequestedProducts(Map<Integer, Integer> productsToDeliver) {
		for (Integer id : productsToDeliver.keySet()) {
			if(warehouse.getProductsQuantity().get(id) == null || warehouse.getProductsQuantity().get(id) < productsToDeliver.get(id)) {
				return false;
			}
		}
		return true;
	}
	
	

}
