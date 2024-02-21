package polymorphism3profesors;

public class Profesor extends Employee{
	private String zvanje;
	private int SCIPapers;
	
	public Profesor() {}
	
	public Profesor(String firstName, String lastName, int age, double workingPlaceCoef, String zvanje, int SCIPapers) {
		super(firstName, lastName, age, workingPlaceCoef);
		this.setZvanje(zvanje);
		this.setSCIPapers(SCIPapers);
	}
	
	public void calculateSalary() {
		this.setSalary(60000 + this.getSCIPapers() * 3000);
	}
	
	public void printPersonData() {
		System.out.printf("First name: %s %n", this.getFirstName());
		System.out.printf("Last name: %s %n", this.getLastName());
		System.out.printf("Age: %d %n", this.getAge());
		System.out.printf("Working place coefficient: %f %n", this.getWorkingPlaceCoef());
		System.out.printf("Education level: %s %n", this.getZvanje());
		System.out.printf("Number of SCI papers: %d %n %n", this.getSCIPapers());
	}

	public String getZvanje() {
		return this.zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public int getSCIPapers() {
		return this.SCIPapers;
	}

	public void setSCIPapers(int sCIPapers) {
		SCIPapers = sCIPapers;
	}
	
	
}
