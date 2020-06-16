package Servlet;

import Handler.ProxyHandler1;
import Proxy1.Redis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InformationServlet",urlPatterns = "/information.do")
public class InformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name=request.getParameter("hbName");
        String phone=request.getParameter("hbPhone");

        ProxyHandler1 proxyHandler1=new ProxyHandler1();
        Redis redis = proxyHandler1.getProxy(Redis.class,"127.0.0.1",12000);

        boolean bo=redis.saveInfo(name,phone);
        if(bo){
            RequestDispatcher rd = request.getRequestDispatcher("payment.jsp");
            rd.forward(request,response) ;
        }else {
            RequestDispatcher rd = request.getRequestDispatcher("information.jsp");
            rd.forward(request,response) ;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
