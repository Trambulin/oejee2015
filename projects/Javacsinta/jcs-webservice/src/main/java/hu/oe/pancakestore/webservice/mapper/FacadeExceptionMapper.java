package hu.oe.pancakestore.webservice.mapper;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import hu.oe.pancakestore.serviceclient.exception.FacadeException;
import hu.oe.pancakestore.webservice.filter.PancakeCrossOriginRequestFilter;

@Provider
public class FacadeExceptionMapper implements ExceptionMapper<FacadeException> {

	@Context
	private HttpHeaders headers;

	@Override
	public Response toResponse(FacadeException e) {
		return Response.status(e.getErrorCode().getHttpStatusCode()).entity(e.build()) //
				.header(PancakeCrossOriginRequestFilter.ALLOW_ORIGIN, "*") //
				.header(PancakeCrossOriginRequestFilter.ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS, HEAD") //
				.header(PancakeCrossOriginRequestFilter.MAX_AGE, "1209600") //
				.header(PancakeCrossOriginRequestFilter.ALLOW_HEADERS, "x-requested-with, origin, content-type, accept, X-Codingpedia, authorization") //
				.header(PancakeCrossOriginRequestFilter.ALLOW_CREDENTIALS, "true") //
				.type(this.headers.getMediaType()).build();
	}

}