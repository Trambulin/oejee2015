package hu.oe.pancakestore.weblayer.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import hu.oe.pancakestore.serviceclient.domain.EmployeeStub;
import hu.oe.pancakestore.serviceclient.exception.FacadeException;
import hu.oe.pancakestore.ejbservice.facade.EmployeeFacade;



@WebServlet("/EmployeePing")
public class EmployeePingServlet extends HttpServlet {

    private static final long serialVersionUID = -7058255202709402208L;

    private static final Logger LOGGER = Logger.getLogger(EmployeePingServlet.class);

    @EJB
    private EmployeeFacade facade;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LOGGER.info("Get Customer by name");
        response.setCharacterEncoding("UTF-8");
        final PrintWriter out = response.getWriter();
        try {
            final EmployeeStub employee = facade.getEmployee("NAGY JOZSEF");
            out.println(employee.toString());
        } catch (final FacadeException e) {
            LOGGER.error(e, e);
            out.println(e.getLocalizedMessage());
        }
        out.close();
    }

}
