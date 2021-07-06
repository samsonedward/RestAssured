package services;

import static org.hamcrest.Matchers.containsString;

import java.io.File;

import org.testng.annotations.Test;

public class IncidentTests extends BaseRequest{
	
	
	@Test
	public void getIncidents(){
		request
			.get("incident")
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("number"),containsString("sys_id"));		
	}
	
	@Test
	public void createIncident(){
		request
			.body(new File("./data/incident1.json"))
			.get("incident")
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("number"),containsString("sys_id"));		
	}
}
