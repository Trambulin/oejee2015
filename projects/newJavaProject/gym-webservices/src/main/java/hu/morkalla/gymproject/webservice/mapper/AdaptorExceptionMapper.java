package hu.morkalla.gymproject.webservice.mapper;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import hu.morkalla.gymproject.ejbservice.exception.AdaptorException;
import hu.morkalla.gymproject.webservice.filter.GYMCrossOriginRequestFilter;

@Provider
public class AdaptorExceptionMapper implements ExceptionMapper<AdaptorException> {

	@Context
	private HttpHeaders headers;

	@Override
	public Response toResponse(AdaptorException e) {
		return Response.status(e.getErrorCode().getHttpStatusCode()).entity(e.build()) //
				.header(GYMCrossOriginRequestFilter.ALLOW_ORIGIN, "*") //
				.header(GYMCrossOriginRequestFilter.ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS, HEAD") //
				.header(GYMCrossOriginRequestFilter.MAX_AGE, "1209600") //
				.header(GYMCrossOriginRequestFilter.ALLOW_HEADERS, "x-requested-with, origin, content-type, accept, X-Codingpedia, authorization") //
				.header(GYMCrossOriginRequestFilter.ALLOW_CREDENTIALS, "true") //
				.type(this.headers.getMediaType()).build();
	}

}
