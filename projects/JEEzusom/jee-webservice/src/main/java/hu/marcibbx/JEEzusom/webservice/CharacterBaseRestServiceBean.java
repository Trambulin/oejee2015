package hu.marcibbx.JEEzusom.webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;
import hu.marcibbx.JEEzusom.ejbservice.facade.CharacterBaseFacade;

@Stateless
public class CharacterBaseRestServiceBean implements CharacterBaseRestService {

	private static final Logger LOGGER = Logger.getLogger(CharacterBaseRestServiceBean.class);

	@EJB
	private CharacterBaseFacade facade;

	@Override
	public CharacterBaseStub getCharacterBase(String name) throws AdaptorException {
		LOGGER.info("Get CharacterBase (" + name + ")");
		return this.facade.getCharacterBaseName(name);
	}
/*
	@Override
	public List<CharacterBaseStub> getAllCharacterBase() throws AdaptorException {
		LOGGER.info("Get all CharacterBases");
		return this.facade.getAllCharacterBases();
	}

	@Override
	public void removeCharacterBase(String neptun) throws AdaptorException {
		LOGGER.info("Remove CharacterBase (" + neptun + ")");
		this.facade.removeCharacterBase(neptun);
	}
*/
	@Override
	public Response optionsAll(String path) {
		return Response.status(Response.Status.NO_CONTENT).build();
	}

}
