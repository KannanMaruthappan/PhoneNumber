package org.teleprovider.api.phoneno;

import java.io.IOException;
import java.util.List;

/**
 * PhoneNumberService interface to retrieve and update details
 * 
 * @author KannanMaruthappan
 */
public interface IPhoneNumberService {

	/**
	 * Function used to get all the phone numbers
	 * 
	 * @return List<String>
	 * @throws IOException
	 */
	public List<String> getAllNumbers() throws IOException;
	
	/**
	 * Function used to get all the phone numbers for given customer name
	 * 
	 * @return List<String>
	 * @throws IOException
	 */
	public List<String> getAllNumbers(String cust) throws IOException;
	
	/**
	 * Function used to activate the phone number for given customer and phone number
	 * 
	 * @return boolean
	 * @throws IOException
	 */
	public boolean activatePhoneNumber(String cust, String phoneNo) throws IOException;
}
