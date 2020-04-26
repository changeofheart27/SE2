package model;

public class World {
	private int id;
	private String country;
	private String infected;
	private String death;
	private String recover;
	private String day;
	
	public World() {
	}

	public World(String country, String infected, String death, String recover, String day) {
		super();
		this.country = country;
		this.infected = infected;
		this.death = death;
		this.recover = recover;
		this.day = day;
	}

	public World(int id, String country, String infected, String death, String recover, String day) {
		super();
		this.id = id;
		this.country = country;
		this.infected = infected;
		this.death = death;
		this.recover = recover;
		this.day = day;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getInfected() {
		return infected;
	}

	public void setInfected(String infected) {
		this.infected = infected;
	}

	public String getDeath() {
		return death;
	}

	public void setDeath(String death) {
		this.death = death;
	}

	public String getRecover() {
		return recover;
	}

	public void setRecover(String recover) {
		this.recover = recover;
	}
	
	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}
}
