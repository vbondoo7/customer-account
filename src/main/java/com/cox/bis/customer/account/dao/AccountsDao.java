package com.cox.bis.customer.account.dao;

import java.util.List;

import com.cox.bis.customer.account.api.model.GetCustomerAccountRequest;
import com.cox.bis.customer.account.api.model.GetCustomerAccountResponse;
import com.cox.bis.customer.account.model.house.Address;


public interface AccountsDao {
	
	public String zipToSiteId(String zip5) throws Exception;
	public List<Address> addressSearch(String streetNumber, String preDirectional, String streetName,
			String postDirectional, String streetType, String unit, String zip5, String matchMethods)  throws Exception;
	public GetCustomerAccountResponse getCustomerAccount(GetCustomerAccountRequest getCustomerAccountRequest) throws Exception;

}
