package org.teleprovider.dao.phoneno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberDao implements IPhoneNumberDao{

	private static IPhoneNumberDao phoneNumberDao = null;
	
	private static Map<String, Map<String, String>> phoneNumberMap = null;
	
	static {
		phoneNumberMap = new HashMap<String, Map<String,String>>();
		
		Map<String, String> phoneNumberStatusMap = new HashMap<String, String>();
		phoneNumberStatusMap.put("+447777777777", "active");
		phoneNumberStatusMap.put("+447555555555", "inactive");
		
		phoneNumberMap.put("John", phoneNumberStatusMap);
	}
	
	private PhoneNumberDao() {
		
	}
	
	public static IPhoneNumberDao getInstance() {
		if(phoneNumberDao == null) {
			phoneNumberDao = new PhoneNumberDao();
		}
		return phoneNumberDao;
	}

	public List<String> getAllNumbers(String cust) throws IOException {
		List<String> phoneNoList = new ArrayList<String>();
		if(cust == null || cust.isEmpty()) {
			for(String custName: phoneNumberMap.keySet()) {
				for(String phoneNos: phoneNumberMap.get(custName).keySet()) {
					phoneNoList.add(phoneNos);
				}
			}
		} else {
			if(phoneNumberMap.get(cust) == null) {
				throw new IOException("Unable to find record for customer " + cust);
			}
			for(String phoneNos: phoneNumberMap.get(cust).keySet()) {
				phoneNoList.add(phoneNos);
			}
		}
		return phoneNoList;
	}

	public boolean activatePhoneNumber(String cust, String phoneNo) throws IOException {
		Map<String, String> phoneNumberStatusMap = phoneNumberMap.get(cust);
		if(phoneNumberMap.get(cust) == null) {
			throw new IOException("Unable to find record for customer " + cust);
		}
		if(phoneNumberStatusMap.get(phoneNo) == null) {
			throw new IOException("Unable to find record for phone number " + phoneNo);
		}
		phoneNumberStatusMap.put(phoneNo, "active"); 
		String status = phoneNumberStatusMap.get(phoneNo);
		return status == "active"? true: false;
	}
}
