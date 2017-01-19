import java.util.ArrayList;
import java.util.List;

public class Warehouse {

	private int id;
	private int x;
	private int y;
	private List<Product> products;

	public Warehouse(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.products = new ArrayList<Product>();
	}

	public Warehouse(int x, int y, List<Product> products) {
		super();
		this.x = x;
		this.y = y;
		this.products = new ArrayList<>(products);
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
	
	public List<Product> getProducts() {
		return products;
	}

}
