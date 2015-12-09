package hu.shruikan.somenewproject.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.shruikan.somenewproject.ejbservice.domain.ProductStub;
import hu.shruikan.somenewproject.ejbservice.domain.AttributeStub;
import hu.shruikan.somenewproject.ejbservice.exception.AdaptorException;
import hu.shruikan.somenewproject.ejbservice.facade.ProductFacade;

import hu.shruikan.somenewproject.persistence.entity.Product;
import hu.shruikan.somenewproject.persistence.entity.trunk.ProductCategory;

@WebServlet("/ProductPing")
public class ProductPingServlet extends HttpServlet {

	private static final long serialVersionUID = -7058255201209402208L;

	private static final Logger LOGGER = Logger.getLogger(ProductPingServlet.class);

	@EJB
	private ProductFacade facade;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get Product by user");
		response.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		try {				
			final ProductStub product = this.facade.getProduct((long)1);
			out.println(product.toString());
			for (AttributeStub item : product.getAttributes()) {
				out.println(item);
			}			
		} catch (final AdaptorException e) {
			LOGGER.error(e, e);
			out.println(e.getLocalizedMessage());
		}
		out.close();
	}

}
