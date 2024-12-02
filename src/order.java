
import java.util.Date;
import java.util.List;


class Order {
    private Date date;
    private String status;
    private List<OrderDetail> orderDetails;
    
    //konstruktor
    public Order(Date date, String status, List<OrderDetail> orderDetails) {
        this.date = date;
        this.status = status;
        this.orderDetails = orderDetails;
    }

    //methods
    public float calcSubTotal() {
        float subTotal = 0;
        for (OrderDetail detail : orderDetails) {
            subTotal += detail.calcSubTotal();
        }
        return subTotal;
    }

    public float calcTax() {
        return calcSubTotal() * 0.1f; // Assume 10% tax rate
    }

    public float calcTotal() {
        return calcSubTotal() + calcTax();
    }

    public float calcTotalWeight() {
        float totalWeight = 0;
        for (OrderDetail detail : orderDetails) {
            totalWeight += detail.calcWeight();
        }
        return totalWeight;
    }
    
}
    
