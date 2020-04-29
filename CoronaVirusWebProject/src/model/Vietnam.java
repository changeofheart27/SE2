<<<<<<< HEAD
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
=======
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
>>>>>>> c6a155c02ce12d83b0e998b2ba28791d5e450a0f
