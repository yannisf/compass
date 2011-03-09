package gr.fragsoft.model;

import java.util.ArrayList;
import java.util.List;

public class Company {
	
	private Long id;
	private String name;
	private List<Employee> employees;
	
	public Company() { }

	public Company(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public void addEmployee(Employee employee) {
		if(employees == null) {
			employees = new ArrayList<Employee>();
		}
		
		employees.add(employee);
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", employees="
				+ employees + "]";
	}

}
