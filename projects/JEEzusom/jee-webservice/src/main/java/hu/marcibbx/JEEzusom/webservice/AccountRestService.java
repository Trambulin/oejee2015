package hu.marcibbx.JEEzusom.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.GET;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;


import hu.marcibbx.JEEzusom.ejbservice.domain.AccountStub;
import hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub;
import hu.marcibbx.JEEzusom.ejbservice.exception.AdaptorException;

@Path("/account")
public interface AccountRestService {

	@PUT
	@Path("/createaccount")
	@Consumes("application/json")
	@Produces("application/json")
	AccountStub createAccount(AccountStub stub) throws AdaptorException;

	@POST
	@Path("/addaccount")
	void addAccount(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName, @FormParam("name") String name, @FormParam("email") String email, @FormParam("password") String password) throws AdaptorException;
	
	@GET
	@Path("/{accountId}")
	@Produces("application/json")
	List<CharacterBaseStub> getCharacterBases(@PathParam("accountId") Long accountId) throws AdaptorException;
	
	@GET
	@Path("/accounts")
	@Produces("application/json")
	List<AccountStub> getAllAccounts() throws AdaptorException;
	
	@GET
	@Path("/{name}")
	@Produces("application/json")
	AccountStub getAccount(@PathParam("name") String name) throws AdaptorException;
	
	@DELETE
	@Path("/{accountId}")
	void removeAccount(@PathParam("accountId") Long accountId) throws AdaptorException;

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
