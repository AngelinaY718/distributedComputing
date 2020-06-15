package JavaBean;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Date;


public class Flight implements Serializable {
    private static final long serialVersionUID = 1L;
    private int ticketId;
    private String ticketDepart;
    private String ticketArrive;
    private Date ticketDate;
    private int companyId;
    private int ticketCount;//
    private int ticketPrice;
    private Time flightTime;
    private String flightNumber;

    @Override
    public String toString() {
        return "Flight{" +
                "ticketId=" + ticketId +
                ", ticketDepart='" + ticketDepart + '\'' +
                ", ticketArrive='" + ticketArrive + '\'' +
                ", ticketDate=" + ticketDate +
                ", companyId=" + companyId +
                ", ticketCount=" + ticketCount +
                ", ticketPrice=" + ticketPrice +
                ", flightTime=" + flightTime +
                ", flightNumber='" + flightNumber + '\'' +
                '}';
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketDepart() {
        return ticketDepart;
    }

    public void setTicketDepart(String ticketDepart) {
        this.ticketDepart = ticketDepart;
    }

    public String getTicketArrive() {
        return ticketArrive;
    }

    public void setTicketArrive(String ticketArrive) {
        this.ticketArrive = ticketArrive;
    }

    public Date getTicketDate() {
        return ticketDate;
    }

    public void setTicketDate(Date ticketDate) {
        this.ticketDate = ticketDate;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getTicketCount() {
        return ticketCount;
    }

    public void setTicketCount(int ticketCount) {
        this.ticketCount = ticketCount;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Time getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Time flightTime) {
        this.flightTime = flightTime;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }
}
