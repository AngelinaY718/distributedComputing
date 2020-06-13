package Servlet;


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
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


        String name=request.getParameter("UserName");
        String password=request.getParameter("Password");
        HttpSession session = request.getSession();
        try {
            FlightServiceImp flightServiceImp=new FlightServiceImp();
            boolean bo=flightServiceImp.login(name,password);
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
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
