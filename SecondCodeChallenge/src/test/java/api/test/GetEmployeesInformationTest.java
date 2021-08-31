package api.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import api.utils.RestUtils;

public class GetEmployeesInformationTest extends RestUtils {
	
	@Test(dataProvider="id_employee")
	public void printEmployeeInformation(String id) {
		getEmployeeInformation(id);
	}
	
	@Test
	public void getAllEmployess() {
		getAllEmployees(); 
	}
	
	@DataProvider(name = "id_employee")
	public Object[][] dataSet(){
		return new Object[][]
				{
					{"2"},
					{"3"},
					{"4"},
				};
	}

}
