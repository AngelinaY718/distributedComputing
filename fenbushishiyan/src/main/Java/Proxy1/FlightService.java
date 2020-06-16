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
    public String order(Order order);
    public List<Order> searchOrders() throws SQLException;
    public Order searchOrder() throws SQLException;
    public Flight searchFlight1(int i) throws SQLException;
}
