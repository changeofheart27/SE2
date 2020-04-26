package model;

public class Vietnam {
	private int id;
	private String province;
	private String infected;
	private String death;
	private String recover;
	private String day;
	
	public Vietnam() {
	}
	
	public Vietnam(String province, String infected, String death, String recover, String day) {
		super();
		this.province = province;
		this.infected = infected;
		this.death = death;
		this.recover = recover;
		this.day = day;
	}

	public Vietnam(int id, String province, String infected, String death, String recover, String day) {
		super();
		this.id = id;
		this.province = province;
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

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
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
