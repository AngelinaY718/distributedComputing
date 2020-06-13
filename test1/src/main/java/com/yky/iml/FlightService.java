package com.yky.iml;

import com.yky.entity.Flight;
import com.yky.entity.Order;
import com.yky.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface FlightService {
    public User login(String a,String b);
    public List<Flight> searchFlight(Flight flight) throws SQLException ;
    public List<Flight> sortFlight(Flight flight) throws SQLException;
    public String order(Order order) throws SQLException;
    public List<Order> searchOrder() throws SQLException;

}
