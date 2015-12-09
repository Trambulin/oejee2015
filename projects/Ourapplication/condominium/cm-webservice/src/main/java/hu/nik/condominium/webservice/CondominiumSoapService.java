package hu.nik.condominium.webservice;


import hu.nik.condominium.ejbservice.domain.CondominiumGroup;
import hu.nik.condominium.ejbservice.domain.CondominiumSoapStub;
import hu.nik.condominium.ejbservice.exception.ServiceException;
import hu.nik.condominium.ejbservice.service.CondominiumGroupService;
import hu.nik.condominium.webservice.exception.CondominiumServiceException;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "Condominium", serviceName = "CondominiumSoapService", targetNamespace = "http://www.nik.condominium.hu/Condominium")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL, parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
public class CondominiumSoapService {

    private static final Logger LOGGER = Logger.getLogger(CondominiumSoapService.class);


    @EJB
    private CondominiumGroupService service;


    @WebMethod(action = "http://www.nik.condominium.hu/Condominium/addCondominium", operationName = "AddItemRequest")
    @WebResult(name = "AddItemResponse", partName = "addItemPart")
    public void addItem(@WebParam(name = "item") final CondominiumSoapStub condominiumSoapStub) throws CondominiumServiceException {
        try {
            this.service.addItem(condominiumSoapStub);
        } catch (final ServiceException e) {
            throw new CondominiumServiceException(e.getMessage(), e.getError());
        }
    }

    @WebMethod(action = "http://www.nik.condominium.hu/Condominium/getCondominiums", operationName = "GetItemsRequest")
    @WebResult(name = "GetItemsResponse", partName = "getItemsPart")
    public CondominiumGroup getItems() throws CondominiumServiceException {
        try {
            return this.service.getItems();
        } catch (final ServiceException e) {
            throw new CondominiumServiceException(e.getMessage(), e.getError());
        }
    }

    @WebMethod(action = "http://www.nik.condominium.hu/Condominium/getCondominiums/getIdentifier", operationName = "GetIdentifierRequest")
    @WebResult(name = "GetIdentifierResponse", partName = "getIdentifierPart")
    public String getIdentifier() throws CondominiumServiceException {
        try {
            return this.service.getIdentifier();
        } catch (final ServiceException e) {
            throw new CondominiumServiceException(e.getMessage(), e.getError());
        }
    }

    @WebMethod(action = "http://www.nik.condominium.hu/Condominium/getCondominiums/setIdentifier", operationName = "SetIdentifierRequest")
    @WebResult(name = "SetIdentifierResponse", partName = "setIdentifierPart")
    public void setIdentifier(@WebParam(name = "identifier") final String identifier) throws CondominiumServiceException {
        try {
            this.service.setIdentifier(identifier);
        } catch (final ServiceException e) {
            throw new CondominiumServiceException(e.getMessage(), e.getError());
        }
    }

    @WebMethod(action = "http://www.nik.condominium.hu/Condominium/getCondominiums/saveCondominiums", operationName = "saveCondominiumsRequest")
    @WebResult(name = "saveCondominiumsResponse", partName = "saveCondominiumsPart")
    public void saveCondominiums() throws CondominiumServiceException {
        try {
             this.service.saveAll();
        } catch (final ServiceException e) {
            throw new CondominiumServiceException(e.getMessage(), e.getError());
        }
    }
}
