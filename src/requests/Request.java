package requests;

import java.util.Map;

public class Request {

	private int id;
	private int reqX;
	private int reqY;
	private Map<Integer, Integer> productsToDeliver;
	
	public Request(int id, int x, int y, Map<Integer, Integer> products) {
		super();
		this.id = id;
		this.reqX = x;
		this.reqY = y;
		this.productsToDeliver = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReqX() {
		return reqX;
	}

	public void setReqX(int reqX) {
		this.reqX = reqX;
	}

	public int getReqY() {
		return reqY;
	}

	public void setReqY(int reqY) {
		this.reqY = reqY;
	}

	public Map<Integer, Integer> getProductsToDeliver() {
		return productsToDeliver;
	}

	public void setProductsToDeliver(Map<Integer, Integer> productsToDeliver) {
		this.productsToDeliver = productsToDeliver;
	}

}
