package Proxy1;



import JavaBean.Flight;
import JavaBean.Order;
import JavaBean.User;

import java.sql.SQLException;
import java.util.List;

public interface FlightService {
    public boolean login(String a, String b);
    public List<Flight> searchFlight(Flight flight) throws SQLException ;
    public List<Flight> sortFlight(Flight flight) throws SQLException;
    public String order(int i,String s1,String s2,String s3);
    public List<Order> searchOrders(String s) throws SQLException;
    public Order searchOrder() throws SQLException;
    public Flight searchFlight1(int i) throws SQLException;
}
