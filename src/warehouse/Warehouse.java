package warehouse;
import java.util.HashMap;
import java.util.Map;

import product.Product;

public class Warehouse {

	private int id;
	private int x;
	private int y;
	private Map<Integer, Integer> productsQuantity;

	private Map<Integer, Product> products;

	public Warehouse(int x, int y) {
		this.productsQuantity = new HashMap<>();
		this.products = new HashMap<>();
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
		return products;
	}
	
	public Map<Integer, Integer> getProductsQuantity() {
		return productsQuantity;
	}
	
	public void addProduct(Product product, int quantity) {
		productsQuantity.put(product.getId(), quantity);
		products.put(product.getId(), product);
	}

}
