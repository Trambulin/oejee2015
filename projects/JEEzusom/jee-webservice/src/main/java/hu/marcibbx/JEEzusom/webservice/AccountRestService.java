package hu.marcibbx.JEEzusom.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

//import hu.marcibbx.JEEzusom.ejbservice.domain.AccountCriteria;
//import hu.marcibbx.JEEzusom.ejbservice.domain.AccountDetailStub;
//import hu.marcibbx.JEEzusom.ejbservice.domain.AccountInputStub;
import hu.marcibbx.JEEzusom.ejbservice.domain.AccountStub;
import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;

@Path("/mark")
public interface AccountRestService {

	@POST
	@Path("/stat")
	@Produces("application/json")
	List<CharacterBaseStub> getCharacterBases(Long accountId) throws AdaptorException;


	/*@PUT
	@Path("/add")
	@Consumes("application/json")
	@Produces("application/json")
	AccountStub addAccount(AccountInputStub stub) throws AdaptorException;
*/
	/*@POST
	@Consumes("application/xml")
	@Produces("application/xml")
	@Path("/get/{studentneptun}")
	AccountStub getMatchingAccount(@PathParam("studentneptun") String studentNeptun, AccountCriteria criteria) throws AdaptorException;
*/
	@OPTIONS
	@Path("{path:.*}")
	Response optionsAll(@PathParam("path") String path);

}
