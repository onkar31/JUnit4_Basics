package services;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorServiceTest 
{
	int counter = 0;
	
	@BeforeClass	//before all test cases 
	public static void init() {
		System.out.println("Before all Test cases: ");
		System.out.println("Started Date : "+ new Date());
		//connect server //open files
	}
		
	//test method of addTwoNmbers
	
	@Before
	public void beforeEach() {
		System.out.println("++Before each test case++");
		counter = 0;
	}
	
	@Test(timeout = 2000)
	public void addTwoNumbersTest() throws InterruptedException {
		for(int i = 1 ; i <= 20 ; i++) {
			counter += i;
		}
		Thread.sleep(3000);	//Tc should fail bcz sleep time is greater than timeout
		System.out.println("Test for addTwoNumbersTest");
		int actualResult = CalculatorService.addTwoNumbers(12, 13);
		int expectedResult = 25;
		System.out.println("Counter value in first test case : "+counter);
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void sumAnyNumbersTest() {
		for(int i = 1 ; i <= 100 ; i++) {
			counter += i;
		}
		
		System.out.println("Test for sumAnyNumbersTest");
		int actualResult = CalculatorService.sumAnyNumbers(10,40,50,70,80);
		int expectedResult = 250;
		System.out.println("Counter value in second test case : "+counter);
		Assert.assertEquals(expectedResult, actualResult);
	}
	
	@AfterClass		//after all test cases
	public static void cleanup() {
		System.out.println("After all Test cases: ");
		System.out.println("End Test cases : "+ new Date());
		//disconnect server  // close files 
	}
		 
	/* JUnit 4 Annotations
	 * 1. Test 
	 * 2. BeforeClass 
	 * 3. AfterClass 
	 * 4. Before 
	 * 5. After
	 */	
}
