package hu.shruikan.somenewproject.webservice.mapper;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;
import hu.shruikan.somenewproject.webservice.filter.SnpCrossOriginRequestFilter;

@Provider
public class AdaptorExceptionMapper implements ExceptionMapper<AdaptorException> {

	@Context
	private HttpHeaders headers;

	@Override
	public Response toResponse(AdaptorException e) {
		return Response.status(e.getErrorCode().getHttpStatusCode()).entity(e.build()) //
				.header(SnpCrossOriginRequestFilter.ALLOW_ORIGIN, "*") //
				.header(SnpCrossOriginRequestFilter.ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS, HEAD") //
				.header(SnpCrossOriginRequestFilter.MAX_AGE, "1209600") //
				.header(SnpCrossOriginRequestFilter.ALLOW_HEADERS, "x-requested-with, origin, content-type, accept, X-Codingpedia, authorization") //
				.header(SnpCrossOriginRequestFilter.ALLOW_CREDENTIALS, "true") //
				.type(this.headers.getMediaType()).build();
	}

}
