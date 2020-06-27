package Servlet;

import Handler.ProxyHandler1;
import JavaBean.Flight;
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
import java.util.List;

@WebServlet(name = "HomepageServlet",urlPatterns = "/homepage.do")
public class HomepageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        ServletContext servletContext = this.getServletContext();

        String depart= (String) request.getParameter("brPlaceStart");
        String arrive= (String) request.getParameter("brPlaceEnd");
        String darein= (String) request.getParameter("brTimeStart");

        System.out.println(1);
        System.out.println(depart);
        System.out.println(arrive);
        System.out.println(darein);
        System.out.println(2);
        Flight searchflight=new Flight();
        searchflight.setTicketDepart(depart);
        searchflight.setTicketArrive(arrive);
        if(darein.equals("今日")){
            searchflight.setTicketDate(1);
        }else if(darein.equals("明日")){
            searchflight.setTicketDate(2);
        }else if(darein.equals("后天")){
            searchflight.setTicketDate(3);
        }

        ProxyHandler1 proxyHandler1=new ProxyHandler1();
        FlightService flight = proxyHandler1.getProxy(FlightService.class,"39.101.217.212",12000);
        try {
            List<Flight> flights=flight.searchFlight(searchflight);
            if(flights.size()!=0){
                RequestDispatcher rd = request.getRequestDispatcher("searchresult.jsp");
                servletContext.setAttribute("list",flights);
                System.out.println(flights.size());
                rd.forward(request,response) ;
            }else {
                RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
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
