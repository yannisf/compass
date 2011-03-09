package gr.fragsoft.compass;

import java.net.URL;

import org.compass.core.Compass;
import org.compass.core.config.CompassConfigurationFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class CompassWrapper {
	
	private static final Logger log = LoggerFactory .getLogger(CompassWrapper.class);
	private static final CompassWrapper INSTANCE = new CompassWrapper();
	private Compass compass;
	
	private CompassWrapper() {
		log.info("Initializing compass wrapper...");
		URL configuration = CompassWrapper.class.getResource("/compass.cfg.xml");
		URL mappings = CompassWrapper.class.getResource("/mappings.cpm.xml");
		log.info("Creating compass object...");
		compass = CompassConfigurationFactory.newConfiguration()
			.configure(configuration).addURL(mappings).buildCompass(); 
	}

	public Compass getCompass() {
		return compass;
	}
	
	public static CompassWrapper getInstance() {
		return INSTANCE;
	}

}
