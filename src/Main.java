
import customer.Customer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // membuat objek item
        Item item1 = new Item(2.5f, "KOmputer");
        Item item2 = new Item(0.7f, "Headphone");
        
        //membuat objek orderdetail
        OrderDetail orderDetail1 = new OrderDetail(1, "Taxable", item1);
        OrderDetail orderDetail2 = new OrderDetail(3, "Taxable", item2);
        
        //membuat list untuk orderdetail
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(orderDetail1);
        orderDetails.add(orderDetail2);
        
        // membuat objek order
        Order order = new Order(new Date(), "Confirmed", orderDetails);
        
        // menghitung total order
         System.out.println("Subtotal: " + order.calcSubTotal());
        System.out.println("Total Tax: " + order.calcTax());
        System.out.println("Total Amount: " + order.calcTotal());
        System.out.println("Total Weight: " + order.calcTotalWeight() + " kg");
        
        //membuat objek customer
        Customer customer = new Customer("Ardi", "Jl. Delima No.4");
        System.out.println("\nCustomer Details:");
        System.out.println("Name: " + customer.getName());
        System.out.println("Address: " + customer.getAddress());
        
        //membuat pembayaran dengan cash
        Payment payment = new cash(order.calcTotal(), 300.0f);
        if (payment.authorized()) {
            System.out.println("\nPayment authorized: Cash payment accepted.");
        } else {
            System.out.println("\nPayment failed: Insufficient cash.");
        }
        
        // membuat pembayaran dengan check
        Payment checkPayment = new Check(order.calcTotal(), "Ardi", "BankDKI");
        if (checkPayment.authorized()) {
            System.out.println("Payment authorized: Check payment accepted.");
        }
        
        // membuat pembayaran dengan credit
        Payment creditPayment = new Credit(order.calcTotal(), "1224-2407-2004-3456", "Visa", "12/25");
        if (creditPayment.authorized()) {
            System.out.println("Payment authorized: Credit card payment accepted.");
        }

        
        
        
    }

   
    
}
