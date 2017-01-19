package warehouse;
import java.util.HashMap;
import java.util.Map;

public class Warehouse {

	private int id;
	private int x;
	private int y;
	private Map<Integer, Integer> products = new HashMap<>();

	public Warehouse(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		
	}

	public Warehouse(int x, int y, Map<Integer, Integer> products) {
		super();
		this.x = x;
		this.y = y;
		this.products = products;
	}

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
	
	public Map<Integer, Integer> getProducts() {
		return products;
	}
	
	public void addProduct(int id, int quantity) {
		products.put(id, quantity);
	}

}
