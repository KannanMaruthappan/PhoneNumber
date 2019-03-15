package org.teleprovider.api.phoneno;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for PhoneNumberService.
 */
public class PhoneNumberServiceTest {
   
	private IPhoneNumberService service = null;
	
	private List<String> expectedPhoneNumbers = null;
	
	/** * Initialization */
	@Before
	public void setUp() {
		service = new PhoneNumberService();
		
		expectedPhoneNumbers = new ArrayList<String>();
		expectedPhoneNumbers.add("+447777777777");
		expectedPhoneNumbers.add("+447555555555");
		
	}

	/** * Test case for add method */
	@Test
	public void getAllNumbersSucessTest() {
		try {
			assertEquals(expectedPhoneNumbers, service.getAllNumbers());
		} catch (IOException e) {
			
		}
	}

	@Test
	public void getCustNumbersSucessTest() {
		try {
			assertEquals(expectedPhoneNumbers, service.getAllNumbers("John"));
		} catch (IOException e) {
			
		}
	}
	
	@Test(expected = IOException.class)
	public void getCustNumbersFailureTest() throws IOException {
		assertEquals(expectedPhoneNumbers, service.getAllNumbers("Josh"));
	}
	
	@Test
	public void activePhoneNumberSucessTest() {
		try {
			assertEquals(true, service.activatePhoneNumber("John", "+447555555555"));
		} catch (IOException e) {
			
		}
	}
	
	@Test(expected = IOException.class)
	public void activePhoneNumberFailureTest() throws IOException {
		assertEquals(true, service.activatePhoneNumber("Josh", "+447555555555"));
	}
	
	/** * destroy the object */
	@After
	public void tearDown() {
		service = null;
		expectedPhoneNumbers = null;
	}
}