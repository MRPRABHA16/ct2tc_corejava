package edu.svit.sf04java.oops;

public class student
{
	private int id;
	private String name;
	private String departement;
	private String location;
	
	
	//defaultconstructor
	public student()
	{
		super();
	}

	//parametersideconstructor
	public student(int id, String name, String departement, String location)
	{
		super();
		this.id = id;
		this.name = name;
		this.departement = departement;
		this.location = location;
	}

	//getters and setters

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "student [id=" + id + ", name=" + name + ", departement=" + departement + ", location=" + location + "]";
	}

	
}
