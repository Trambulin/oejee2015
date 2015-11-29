package hu.tram.webservice.mapper;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import hu.tram.ejbservice.exception.FacadeException;
import hu.tram.webservice.filter.CarRentCrossOriginRequestFilter;


@Provider
public class AdaptorExceptionMapper implements ExceptionMapper<FacadeException> {

	@Context
	private HttpHeaders headers;

	@Override
	public Response toResponse(FacadeException e) {
		return Response.status(e.getErrorCode().getHttpStatusCode()).entity(e.build()) //
				.header(CarRentCrossOriginRequestFilter.ALLOW_ORIGIN, "*") //
				.header(CarRentCrossOriginRequestFilter.ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS, HEAD") //
				.header(CarRentCrossOriginRequestFilter.MAX_AGE, "1209600") //
				.header(CarRentCrossOriginRequestFilter.ALLOW_HEADERS, "x-requested-with, origin, content-type, accept, X-Codingpedia, authorization") //
				.header(CarRentCrossOriginRequestFilter.ALLOW_CREDENTIALS, "true") //
				.type(this.headers.getMediaType()).build();
	}

}
