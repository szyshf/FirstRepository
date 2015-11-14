
package com.bright.comm;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "CreditCardPortType", targetNamespace = "www.szyshf.vicp.net/CreditCard")
@SOAPBinding(use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public interface CreditCardPortType {

	@WebMethod(operationName = "creditProcess", action = "")
	@WebResult(name = "out", targetNamespace = "www.szyshf.vicp.net/CreditCard")
	public int creditProcess(
			@WebParam(name = "in0", targetNamespace = "www.szyshf.vicp.net/CreditCard")
			String in0,
			@WebParam(name = "in1", targetNamespace = "www.szyshf.vicp.net/CreditCard")
			double in1);

}
