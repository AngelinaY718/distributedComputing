package Servlet;

import Handler.ProxyHandler1;
import JavaBean.Order;
import Proxy1.FlightService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "orderlistServlet",urlPatterns = "/orderlist.do")
public class orderlistServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext context=request.getServletContext();
        HttpSession session=request.getSession();
        String name= (String) session.getAttribute("name");

        ProxyHandler1 proxyHandler1=new ProxyHandler1();
        FlightService flightService=proxyHandler1.getProxy(FlightService.class,"39.101.217.212",12000);
        try {
            List<Order> orders=flightService.searchOrders(name);
            System.out.println(123);
            if(orders!=null){
                RequestDispatcher rd = request.getRequestDispatcher("orderlist.jsp");
                context.setAttribute("orders",orders);
                System.out.println(orders.size());
                System.out.println();
                rd.forward(request,response) ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
