
public class Drone {
	private int id;
	private int battery;
	private double capacity;
	private int chargingRate;
	private boolean isFlying;
	
	public Drone(int id, int battery, double capacity, int chargingRate, boolean isFlying) {
		super();
		this.id = id;
		this.battery = battery;
		this.capacity = capacity;
		this.chargingRate = chargingRate;
		this.isFlying = isFlying;
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
	public boolean getIsFlying() {
		return isFlying;
	}
	public void setIsFlying(boolean isFlying) {
		this.isFlying = isFlying;
	}
	
	
	public void fly(int distance) {
		this.setBattery(this.getBattery() - distance * 2);
	}
	
	public void charge(int minute) {
		return;
	}
	

}
