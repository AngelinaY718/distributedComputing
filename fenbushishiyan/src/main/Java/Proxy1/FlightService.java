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
    public String order(Order order) throws SQLException;
    public List<Order> searchOrder() throws SQLException;

}
