package Servlet;

import Handler.ProxyHandler1;
import JavaBean.Flight;
import JavaBean.Order;
import Proxy1.FlightService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "confirmationServlet",urlPatterns = "/confirmation.do")
public class confirmationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context=request.getServletContext();
        Order order=new Order();
        Flight flight=new Flight();

        ProxyHandler1 proxyHandler1=new ProxyHandler1();
        FlightService flightService=proxyHandler1.getProxy(FlightService.class,"39.101.217.212",12000);
        try {
            order=flightService.searchOrder();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        RequestDispatcher rd = request.getRequestDispatcher("confirmation.jsp");
        context.setAttribute("order",order);
        System.out.println(3);
        rd.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
