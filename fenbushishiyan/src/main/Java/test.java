import JavaBean.Flight;
import Proxy1.FlightServiceImp;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        FlightServiceImp flightServiceImp=new FlightServiceImp();
        Flight flight=flightServiceImp.searchFlight1(100001);
        System.out.println(flight.getTicketArrive());
    }
}
