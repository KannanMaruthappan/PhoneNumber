package org.teleprovider.dao.phoneno;

import java.io.IOException;
import java.util.List;

public interface IPhoneNumberDao {

	public List<String> getAllNumbers(String cust) throws IOException;
	
	public boolean activatePhoneNumber(String cust, String phoneNo) throws IOException;
}
