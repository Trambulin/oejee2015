package hu.oe.pancakestore.weblayer.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


@WebServlet("/index")
public class IndexPageServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1965219420444388645L;
	private static final String PAGE = "index.jsp";

	private static final Logger LOGGER = Logger.getLogger(IndexPageServlet.class);


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("Get main page");

	    RequestDispatcher view = request.getRequestDispatcher(PAGE);
	    view.forward(request, response); 
	}

}
