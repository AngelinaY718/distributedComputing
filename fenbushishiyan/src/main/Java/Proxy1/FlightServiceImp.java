package Proxy1;


import JavaBean.Flight;
import JavaBean.Order;
import JavaBean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightServiceImp implements FlightService{


    public FlightServiceImp() throws SQLException {
    }

    @Override
    public boolean login(String a, String b) {
        Statement state;
        boolean bo=false;
        User user = null;
        try {
            Connection connection = Link.getConnection();
            state = connection.createStatement();
            String sql="select * from user where id='"+a+"' and password='"+b+"'";
            ResultSet re=state.executeQuery(sql);
            if(re.next()){
                bo=true;
            }
            state.close();
            Link.close(connection,null,re);
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return bo;

    }


    @Override
    public List<Flight> searchFlight(Flight flight) throws SQLException {
        Connection connection = Link.getConnection();
        System.out.println("开始查询机票");
        PreparedStatement state = connection.prepareStatement("select * from ticketinfo where ticketDepart=? and ticketArrive=? and ticketDate=? order by flightTime desc;");
        //PreparedStatement state = connection.prepareStatement("select * from ticketinfo where ticketDepart='上海' and ticketArrive='西安'");
        state.setString(1, flight.getTicketDepart());
        state.setString(2, flight.getTicketArrive());
        state.setInt(3, flight.getTicketDate());
        //3、查询数据库并返回结果
        ResultSet result = state.executeQuery();
        List<Flight> flights= new ArrayList<Flight>();
        while (result.next()) {
            Flight flight1 = new Flight();
            flight1.setTicketId(result.getInt(1));
            flight1.setTicketDepart(result.getString(2));
            flight1.setTicketArrive(result.getString(3));
            flight1.setTicketDate(result.getInt(4));
            flight1.setCompanyId(result.getInt(5));
            flight1.setTicketCount(result.getInt(6));
            flight1.setTicketPrice(result.getInt(7));
            flight1.setFlightTime(result.getTime(8));
            flight1.setFlightNumber(result.getString(9));
            flights.add(flight1);
        }
        Link.close(connection,state,result);

        return flights;
    }

    @Override
    public List<Flight> sortFlight(Flight flight) {
        List<Flight> flights= new ArrayList<Flight>();
        System.out.println("开始查询机票");
        PreparedStatement state = null;
        try {
            Connection connection = Link.getConnection();
            state = connection.prepareStatement("select * from ticketinfo where ticketDepart=? and ticketArrive=? and ticketDate=? order by ticketPrice desc;");
            //PreparedStatement state = connection.prepareStatement("select * from ticketinfo where ticketDepart='上海' and ticketArrive='西安'");
            state.setString(1, flight.getTicketDepart());
            state.setString(2, flight.getTicketArrive());
            state.setInt(3, flight.getTicketDate());
            //3、查询数据库并返回结果
            ResultSet result = state.executeQuery();
            while (result.next()) {
                Flight flight1 = new Flight();
                flight1.setTicketId(result.getInt(1));
                flight1.setTicketDepart(result.getString(2));
                flight1.setTicketArrive(result.getString(3));
                flight1.setTicketDate(result.getInt(4));
                flight1.setCompanyId(result.getInt(5));
                flight1.setTicketCount(result.getInt(6));
                flight1.setTicketPrice(result.getInt(7));
                flight1.setFlightTime(result.getTime(8));
                flight1.setFlightNumber(result.getString(9));
                flights.add(flight1);
            }
            Link.close(connection,state,result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flights;
    }

    @Override
    public String order(int i,String s1,String s2,String s3){
        try {
            Connection connection = Link.getConnection();
            String result ="失败";
            String sql="insert into orderlist(ticketId,userId,username,phone) values(?,?,?,?)";
            PreparedStatement state = connection.prepareStatement(sql);
            state.setInt(1,i);
            state.setString(2,s1);
            state.setString(3,s2);
            state.setString(4,s3);
            int rs=state.executeUpdate();
            if(rs==1){
                result = "下订单成功";
            }
            Link.close(connection,null,null);
            System.out.println(result);
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Order> searchOrders(String s) throws SQLException {
        Connection connection = Link.getConnection();
        System.out.println("开始查询");
        PreparedStatement state = connection.prepareStatement("select * from orderlist where userId=?");
        state.setString(1,s);
        //3、查询数据库并返回结果
        ResultSet result = state.executeQuery();
        List<Order> orders= new ArrayList<Order>();
        while (result.next()) {
            Order order1 = new Order();
            order1.setOrderId(result.getInt(1));
            order1.setUserId(result.getString(3));
            order1.setTicketId(result.getInt(2));
            order1.setUsername(result.getString(4));
            order1.setPhone(result.getString(5));
            orders.add(order1);
        }
        System.out.println(12);
        Link.close(connection,state,result);
        return orders;
    }

    @Override
    public Order searchOrder() throws SQLException {
        Connection connection = Link.getConnection();
        Order order=new Order();
        String sql="select * from orderlist order by orderId desc limit 1";
        PreparedStatement state = connection.prepareStatement(sql);
        ResultSet result = state.executeQuery();
        while (result.next()) {
            order.setOrderId(result.getInt(1));
            order.setUserId(result.getString(3));
            order.setTicketId(result.getInt(2));
            order.setUsername(result.getString(4));
            order.setPhone(result.getString(5));
        }
        Link.close(connection,state,result);
        return order;
    }

    @Override
    public Flight searchFlight1(int i) throws SQLException {
        Flight flight=new Flight();
        Connection connection = Link.getConnection();
        System.out.println("开始查询机票");
        String sql="select * from ticketinfo where ticketId=?";
        System.out.println(sql);
        PreparedStatement state = connection.prepareStatement(sql);
        state.setInt(1,i);
        System.out.println("123456");
        //3、查询数据库并返回结果
        ResultSet result = state.executeQuery();
        while (result.next()) {
            flight.setTicketId(result.getInt(1));
            flight.setTicketDepart(result.getString(2));
            flight.setTicketArrive(result.getString(3));
            flight.setTicketDate(result.getInt(4));
            flight.setCompanyId(result.getInt(5));
            flight.setTicketCount(result.getInt(6));
            flight.setTicketPrice(result.getInt(7));
            flight.setFlightTime(result.getTime(8));
            flight.setFlightNumber(result.getString(9));
        }
        System.out.println(flight.getCompanyId());
        Link.close(connection,state,result);
        return flight;
    }
}
