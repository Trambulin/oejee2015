package hu.nik.condominium.webservice;


import hu.nik.condominium.ejbservice.domain.CondominiumSoapStub;
import org.apache.log4j.Logger;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "Condominium", serviceName = "CondominiumSoapService", targetNamespace = "http://www.nik.condominium.hu/Condominium")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class CondominiumSoapService {

    private static final Logger LOGGER = Logger.getLogger(CondominiumSoapService.class);

    @WebMethod(action = "http://www.nik.condominium.hu/Condominium/addCondominium", operationName = "AddItemRequest")
    @WebResult(name = "AddItemResponse", partName = "addItemPart")
    public void addItem(@WebParam(name = "item") final CondominiumSoapStub product) {
        LOGGER.info("METHOD CALLED WITH PARAMS"+product);
    }
}
