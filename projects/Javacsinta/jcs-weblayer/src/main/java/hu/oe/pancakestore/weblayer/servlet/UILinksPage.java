package hu.oe.pancakestore.weblayer.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet("/UILinksPage")
public class UILinksPage extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4891323874264420971L;
	private static final String PAGE = "UILinksPage.jsp";

	private static final Logger LOGGER = Logger.getLogger(UILinksPage.class);


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get UILinksPage");
	    RequestDispatcher view = request.getRequestDispatcher(PAGE);
	    view.forward(request, response); 
	}

}
