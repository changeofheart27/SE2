package model;

public class Vietnam {
	private int id;
	private String provinceName;
	private String currentInfected;
	private String currentDeath;
	private String currentRecover;
	private String date;
	
	public Vietnam() {
	}
	
	public Vietnam(String provinceName, String currentInfected, String currentDeath, String currentRecover, String date) {
		super();
		this.provinceName = provinceName;
		this.currentInfected = currentInfected;
		this.currentDeath = currentDeath;
		this.currentRecover = currentRecover;
		this.date = date;
	}

	public Vietnam(int id, String provinceName, String currentInfected, String currentDeath, String currentRecover, String date) {
		super();
		this.id = id;
		this.provinceName = provinceName;
		this.currentInfected = currentInfected;
		this.currentDeath = currentDeath;
		this.currentRecover = currentRecover;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCurrentInfected() {
		return currentInfected;
	}

	public void setCurrentInfected(String currentInfected) {
		this.currentInfected = currentInfected;
	}

	public String getCurrentDeath() {
		return currentDeath;
	}

	public void setCurrentDeath(String currentDeath) {
		this.currentDeath = currentDeath;
	}

	public String getCurrentRecover() {
		return currentRecover;
	}

	public void setCurrentRecover(String currentRecover) {
		this.currentRecover = currentRecover;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
