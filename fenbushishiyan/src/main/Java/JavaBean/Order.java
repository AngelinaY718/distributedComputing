package JavaBean;

import java.io.Serializable;

public class Order  implements Serializable {
    private static final long serialVersionUID = 1L;
    private int orderId;
    private int ticketId;
    private String userId;
    private String username;
    private String phone;

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", ticketId=" + ticketId +
                ", userId='" + userId +
                "username="+username+
                "phone="+phone+'\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }
}
