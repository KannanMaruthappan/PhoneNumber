package org.teleprovider.api.phoneno;

import java.io.IOException;
import java.util.List;

import org.teleprovider.dao.phoneno.IPhoneNumberDao;
import org.teleprovider.dao.phoneno.PhoneNumberDao;


/**
 * @author kannan.maruthappan
 *
 */
public class PhoneNumberService implements IPhoneNumberService {

	private IPhoneNumberDao phoneNumberDao = PhoneNumberDao.getInstance();
	
	public List<String> getAllNumbers() throws IOException {
		return phoneNumberDao.getAllNumbers(null);
	}

	public List<String> getAllNumbers(String cust) throws IOException {
		return phoneNumberDao.getAllNumbers(cust);
	}

	public boolean activatePhoneNumber(String cust, String phoneNo) throws IOException {
		return phoneNumberDao.activatePhoneNumber(cust, phoneNo);
	}
}
