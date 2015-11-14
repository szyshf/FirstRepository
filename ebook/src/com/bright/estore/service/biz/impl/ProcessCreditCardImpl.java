package com.bright.estore.service.biz.impl;

import com.bright.estore.service.biz.IProcessCredit;
import com.bright.estore.service.dao.IServiceDAOSqlServer;
import com.bright.estore.service.dao.impl.ServiceDAOSqlServerImpl;


public class ProcessCreditCardImpl implements IProcessCredit {

	public int creditProcess(String creditCard, double total) {
		// TODO Auto-generated method stub
		IServiceDAOSqlServer objServer = new ServiceDAOSqlServerImpl();
		return objServer.creditProcess(creditCard, total);
	}

}
