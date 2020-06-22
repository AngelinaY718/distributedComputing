package Servlet;


import Handler.ProxyHandler1;
import Proxy1.FlightService;
import Proxy1.FlightServiceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


        String name=request.getParameter("UserName");
        String password=request.getParameter("Password");
        HttpSession session = request.getSession();
        ProxyHandler1 proxyHandler1=new ProxyHandler1();
        FlightService flight = proxyHandler1.getProxy(FlightService.class,"39.101.217.212",12000);
        boolean bo=flight.login(name,password);
        if(bo){
            RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp") ;
            session.setAttribute("name",name);
            // 把所有的请求向下继续传递
            rd.forward(request,response) ;
        }else {
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp") ;
            // 把所有的请求向下继续传递
            rd.forward(request,response) ;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
