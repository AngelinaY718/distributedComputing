package Servlet;

import Handler.ProxyHandler1;
import JavaBean.Order;
import Proxy1.FlightService;
import Proxy1.Redis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "PaymentServlet",urlPatterns = "/payment.do")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();

        String hbcheckCode=request.getParameter("hbcheckCode");
        String hbCode=request.getParameter("hbCode");
        int price= (int) session.getAttribute("ticketPrice");
        int ticketid= (int) session.getAttribute("ticketid");
        String name= (String) session.getAttribute("name");
        String username= (String) session.getAttribute("username");
        String phone= (String) session.getAttribute("phone");
        System.out.println(price);

        ProxyHandler1 proxyHandler1=new ProxyHandler1();
        Redis redis = proxyHandler1.getProxy(Redis.class,"127.0.0.1",12000);
        FlightService flightService=proxyHandler1.getProxy(FlightService.class,"127.0.0.1",12000);

        if(hbcheckCode.equals(hbCode)){
            boolean bo=redis.pay(price);
            if(bo){
                flightService.order(ticketid,name,username,phone);
                RequestDispatcher rd = request.getRequestDispatcher("confirmation.do");
                rd.forward(request,response) ;
            }else {
                session.removeAttribute("username");
                session.removeAttribute("phone");
                session.removeAttribute("tickerPrice");
                session.removeAttribute("tickerid");
                RequestDispatcher rd = request.getRequestDispatcher("errorpay.jsp");
                rd.forward(request,response) ;
            }
        }else {
            RequestDispatcher rd = request.getRequestDispatcher("payment.jsp");
            rd.forward(request,response) ;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
