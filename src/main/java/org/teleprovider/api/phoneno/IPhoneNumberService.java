package org.teleprovider.api.phoneno;

import java.io.IOException;
import java.util.List;

public interface IPhoneNumberService {

	public List<String> getAllNumbers() throws IOException;
	
	public List<String> getAllNumbers(String cust) throws IOException;
	
	public boolean activatePhoneNumber(String cust, String phoneNo) throws IOException;
}
