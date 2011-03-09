package gr.fragsoft;

import gr.fragsoft.compass.CompassWrapper;
import gr.fragsoft.model.Company;
import gr.fragsoft.model.Employee;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.compass.core.CompassHit;
import org.compass.core.CompassHits;
import org.compass.core.CompassSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GenericTest {
	
	private static final Logger log = LoggerFactory.getLogger(GenericTest.class);
	
	private List<Company> companies;
	
	@BeforeClass
	public void initializeModel() {
		companies = new ArrayList<Company>();

		Employee e0 = new Employee(0L, "MiddleMan");
		
		Company c0 = new Company(0L, "Apple");
		Employee e1 = new Employee(1L, "AppleDude");
		Employee e2 = new Employee(2L, "AppleMan");
		c0.addEmployee(e0);
		c0.addEmployee(e1);
		c0.addEmployee(e2);
		
		Company c1 = new Company(1L, "Microsoft");
		Employee e3 = new Employee(3L, "MicrosoftGuy");
		c1.addEmployee(e0);
		c1.addEmployee(e3);
		
		companies.add(c0);
		companies.add(c1);
	}
	
	@AfterClass
	public void cleanup() {
		CompassWrapper.getInstance().getCompass().close();
	}
	
	@Test
	public void index() {
		CompassSession session = CompassWrapper.getInstance().getCompass().openSession();
		for(Company company: companies) {
			session.create(company);
		}
		session.close();
	}
	
	@Test 
	public void search() {
		CompassSession session = CompassWrapper.getInstance().getCompass().openSession();
		CompassHits hits = session.find("MiddleMan");
		Iterator<CompassHit> iterator = hits.iterator();
		while (iterator.hasNext()) {
			CompassHit hit = iterator.next();
			Object object = hit.data();
			log.info("Found {}", object);
		}
		session.close();
	}

}
