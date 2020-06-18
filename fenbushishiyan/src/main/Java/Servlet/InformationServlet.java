package Servlet;

import Handler.ProxyHandler1;
import Proxy1.Redis;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InformationServlet",urlPatterns = "/information.do")
public class InformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name=request.getParameter("hbName");
        String phone=request.getParameter("hbPhone");

        System.out.println(name);
        System.out.println(phone);

        HttpSession session=request.getSession();
        session.setAttribute("username",name);
        session.setAttribute("phone",phone);


        RequestDispatcher rd = request.getRequestDispatcher("payment.jsp");
        rd.forward(request,response) ;


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
