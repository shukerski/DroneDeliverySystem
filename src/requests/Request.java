package requests;

import java.util.Map;

public class Request {

	private int id;
	private RequestType type;
	private int reqX;
	private int reqY;
	private Map<Integer, Integer> productsToDeliver;

	public Request(int id, RequestType type, int x, int y, Map<Integer, Integer> products) {
		super();
		this.id = id;
		this.type = type;
		this.reqX = x;
		this.reqY = y;
		this.productsToDeliver = products;
	}

	public RequestType getType() {
		return type;
	}

	public void setType(RequestType type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return reqX;
	}

	public void setX(int reqX) {
		this.reqX = reqX;
	}

	public int getY() {
		return reqY;
	}

	public void setY(int reqY) {
		this.reqY = reqY;
	}

	public Map<Integer, Integer> getProductsToDeliver() {
		return productsToDeliver;
	}

	public void setProductsToDeliver(Map<Integer, Integer> productsToDeliver) {
		this.productsToDeliver = productsToDeliver;
	}

}
