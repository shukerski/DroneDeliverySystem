package requests;

import java.util.Map;

public class Request {
	private int id;
	private RequestType type;
	private long dateTime;
	private int reqX;
	private int reqY;
	private Map<Integer, Integer> productsToDeliver;

	public Request(int id, RequestType type, long dateTime, int x, int y, Map<Integer, Integer> products) {
		super();
		this.id = id;
		this.type = type;
		this.dateTime = dateTime;
		this.reqX = x;
		this.reqY = y;
		this.productsToDeliver = products;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
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
