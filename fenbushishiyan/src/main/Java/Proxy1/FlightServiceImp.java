package Proxy1;


import JavaBean.Flight;
import JavaBean.Order;
import JavaBean.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FlightServiceImp implements FlightService{

    private Link dataSource = new Link();
    private Connection connection = dataSource.getConnection();

    public FlightServiceImp() throws SQLException {
    }

    @Override
    public boolean login(String a, String b) {
        Statement state;
        boolean bo=false;
        User user = null;
        try {
            state = connection.createStatement();
            String sql="select * from user where id='"+a+"' and password='"+b+"'";
            ResultSet re=state.executeQuery(sql);
            if(re.next()){
                bo=true;
            }
            state.close();
            re.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return bo;

    }


    @Override
    public List<Flight> searchFlight(Flight flight) throws SQLException {

        System.out.println("开始查询");
        PreparedStatement state = connection.prepareStatement("select * from ticketinfo where ticketDepart=? and ticketArrive=? and ticketDate=?;");
        //PreparedStatement state = connection.prepareStatement("select * from ticketinfo where ticketDepart='上海' and ticketArrive='西安'");
        state.setString(1, flight.getTicketDepart());
        state.setString(2, flight.getTicketArrive());
        state.setDate(3, flight.getTicketDate());
        //3、查询数据库并返回结果
        ResultSet result = state.executeQuery();
        List<Flight> flights= new ArrayList<Flight>();
        while (result.next()) {
            Flight flight1 = new Flight();
            flight1.setTicketId(result.getInt(1));
            flight1.setTicketDepart(result.getString(2));
            flight1.setTicketArrive(result.getString(3));
            flight1.setTicketDate(result.getDate(4));
            flight1.setCompanyId(result.getInt(5));
            flight1.setTicketCount(result.getInt(6));
            flight1.setTicketPrice(result.getInt(7));
            flight1.setFlightTime(result.getTime(8));
            flight1.setFlightNumber(result.getString(9));
            flights.add(flight1);
        }
        result.close();
        state.close();
        return flights;
    }

    @Override
    public List<Flight> sortFlight(Flight flight) {

        return null;
    }

    @Override
    public String order(Order order) throws SQLException {
        String result ="失败";
        String sql="insert into order(ticketId,userId) " +
                "values('"+order.getTicketId()+"','"+order.getUserId()+"';";
        Statement statement=connection.createStatement();
        int rs=statement.executeUpdate(sql);
        if(rs==1){
            result = "下订单成功";
        }
        return result;
    }

    @Override
    public List<Order> searchOrder() throws SQLException {
        System.out.println("开始查询");
        PreparedStatement state = connection.prepareStatement("select * from orderinfo ");

        //3、查询数据库并返回结果
        ResultSet result = state.executeQuery();
        List<Order> orders= new ArrayList<Order>();
        while (result.next()) {
            Order order1 = new Order();
            order1.setOrderId(result.getInt(1));
            order1.setUserId(result.getString(3));
            order1.setTicketId(result.getInt(2));
            orders.add(order1);
        }
        result.close();
        state.close();
        return orders;
    }
}
