package tema1;

/**
 * clasa care defineste un pasager / o persoana
 */

public class Pasager {
	private String name;
	private int age;
	private char ticket;
	private boolean priority_boarding;
	private boolean special_needs;
	
	/**
	 * constructor gol pentru clasele care mostenesc Pasager
	 */
	
	public Pasager() {	
	}
	
	/**
	 * construieste un pasager cu parametrii dati
	 */
	
	public Pasager(String name, int age, char ticket, boolean priority_boarding, boolean special_needs) {
		this.name = name;
		this.age = age;
		this.ticket = ticket;
		this.priority_boarding = priority_boarding;
		this.special_needs = special_needs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getTicket() {
		return ticket;
	}

	public void setTicket(char ticket) {
		this.ticket = ticket;
	}

	public boolean isPriorityBoarding() {
		return priority_boarding;
	}

	public void setPriorityBoarding(boolean priority_boarding) {
		this.priority_boarding = priority_boarding;
	}

	public boolean isSpecialNeeds() {
		return special_needs;
	}

	public void setSpecialNeeds(boolean special_needs) {
		this.special_needs = special_needs;
	}
}


