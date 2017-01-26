package drone;

public class Drone {
	private int id;
	private int battery;
	private int maxBattery;
	private double capacity;
	private int chargingRate;
	private int warehouseID;
	private long availableTime;

	public Drone(int id, int battery, double capacity, int chargingRate, int warehouseId, long availableTime) {
		this.id = id;
		this.battery = battery;
		this.maxBattery = battery;
		this.capacity = capacity;
		this.chargingRate = chargingRate;
		this.warehouseID = warehouseId;
		this.availableTime = availableTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
	
	public int getMaxBattery() {
		return maxBattery;
	}
	
	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public int getChargingRate() {
		return chargingRate;
	}

	public void setChargingRate(int chargingRate) {
		this.chargingRate = chargingRate;
	}

	public int getWarehouseID() {
		return warehouseID;
	}

	public void setWarehouseID(int warehouseID) {
		this.warehouseID = warehouseID;
	}

	public long getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(long availableTime) {
		this.availableTime = availableTime;
	}

	public void fly(int distance) {
		this.setBattery(this.getBattery() - distance * 2);
	}

	public long chargingTime() {
		int neededBattery = this.getMaxBattery() - this.getBattery();
		int minutes = neededBattery / this.getChargingRate();
		return minutes * 60;
	}

}