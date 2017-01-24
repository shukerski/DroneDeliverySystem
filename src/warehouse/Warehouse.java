package warehouse;
import java.util.HashMap;
import java.util.Map;

import product.Product;

public class Warehouse {

	private int id;
	private int x;
	private int y;
	private Map<Integer, Integer> productsIdToQuantity;

	private Map<Integer, Product> productsIdToProduct;

	public Warehouse(int x, int y) {
		this.productsIdToQuantity = new HashMap<>();
		this.productsIdToProduct = new HashMap<>();
		this.x = x;
		this.y = y;
		
	}

//	public Warehouse(int x, int y, Map<Integer, Integer> productsQuantity) {
//		super();
//		this.x = x;
//		this.y = y;
//		this.productsQuantity = products;
//	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Map<Integer, Product> getProducts() {
		return productsIdToProduct;
	}
	
	public Map<Integer, Integer> getProductsQuantity() {
		return productsIdToQuantity;
	}
	
	public void addProduct(Product product, int quantity) {
		productsIdToQuantity.put(product.getId(), quantity);
		productsIdToProduct.put(product.getId(), product);
	}
	
	public boolean checkAvailability(Map<Integer, Integer> idToQuantity) {
		for (Integer id : idToQuantity.keySet()) {
			if(this.getProductsQuantity().get(id) == null || this.getProductsQuantity().get(id) < idToQuantity.get(id)) {
				return false;
			}
		}
		return true;
	}
	
	public void update(Map<Integer, Integer> idToQuantity) {
		for (Integer id : idToQuantity.keySet()) {
			int newValue = getProductsQuantity().get(id) - idToQuantity.get(id);
			this.getProductsQuantity().put(id, newValue);
		}
	}

}
