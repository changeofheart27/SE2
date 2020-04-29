package model;

public class World {
	private int id;
	private String countryName;
	private String currentInfected;
	private String currentDeath;
	private String currentRecover;
	private String date;
	
	public World() {
	}

	public World(String countryName, String currentInfected, String currentDeath, String currentRecover, String date) {
		super();
		this.countryName = countryName;
		this.currentInfected = currentInfected;
		this.currentDeath = currentDeath;
		this.currentRecover = currentRecover;
		this.date = date;
	}

	public World(int id, String countryName, String currentInfected, String currentDeath, String currentRecover, String date) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.currentInfected = currentInfected;
		this.currentDeath = currentDeath;
		this.currentRecover = currentRecover;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
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
