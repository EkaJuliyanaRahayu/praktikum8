| Nama | Eka Juliyana Rahayu |
| ----- | ------------------- |
| NIM | 312310594 |
| Kelas | TI.23.A6 |

# Buatkan kode java dari Diagram Class berikut
![Screenshot 2024-11-29 134021](https://github.com/user-attachments/assets/1fd3dc1c-29ad-4e4b-b6cb-6e87a9de75e0)

# * Class `customer`
```

package customer;
public class Customer {
    private String name;
    private String address;
    
    // konstruktor
    public Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }
    
    // getter dan setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

```

# * Class `order`
```

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
    
```

# * Class `orderDetail`
```

class OrderDetail {
    private int quantity;
    private String taxStatus;
    private Item item;
    
    //konstruktor
    public OrderDetail(int quantity, String taxStatus, Item item) {
        this.quantity = quantity;
        this.taxStatus = taxStatus;
        this.item = item;
    }
    
    // methods
    public float calcSubTotal() {
        return item.getPriceForQuantity(quantity);
    }

    public float calcWeight() {
        return item.getShippingWeight() * quantity;
    }

    public float calcTax() {
        return calcSubTotal() * 0.1f; // Assume 10% tax rate
    }
    
}
```

# * Class `item`
```
class Item {
    private float shippingWeight;
    private String description;
    
    //konstruktor
     public Item(float shippingWeight, String description) {
        this.shippingWeight = shippingWeight;
        this.description = description;
    }
     
     //methods
      public float getPriceForQuantity(int quantity) {
        return quantity * 10.0f; // Assume each item costs 10 units
    }

    public float getTax() {
        return getPriceForQuantity(1) * 0.1f;
    }

    public boolean inStock() {
        return true; // Placeholder, assume always in stock
    }

    public float getShippingWeight() {
        return shippingWeight;
    }
    
}
```
# * Abstract Class `Payment`
```
public abstract class Payment {
    protected float amount;
    
    public Payment(float amount) {
        this.amount = amount;
    }
    
    public abstract boolean authorized();
    
}
```

<p> - Metode `authorized()` terdapat pada method abstrak yang ada di dalam class Payment.
  Berarti setiap subclass yang mewarisi Payment (yaitu Cash, Check, dan Credit)
  harus mengimplementasikan method `authorized()` dengan logika spesifik untuk menentukan apakah pembayaran tersebut valid atau tidak.</p>
<p>- Method `authorized()` disini digunakan untuk memvalidasi pembayaran.</p>  

# * Class `cash`
```

public class cash extends Payment{
    private float cashTendered;
    
    public cash(float amount, float cashTendered) {
        super(amount);
        this.cashTendered = cashTendered;
    }

    @Override
    public boolean authorized() {
        return cashTendered >= amount;
    }
     
}
```
<p> - Dalam class `cash ` metode authorized() memeriksa apakah uang tunai (cashTendered) cukup untuk membayar jumlah total (amount).</p>
<p>- Jika cukup, maka authorized() akan mengembalikan true, artinya pembayaran disetujui.</p>

# * Class ` check`
```

public class Check extends Payment {
    private String name;
    private String bankID;
    
    public Check(float amount, String name, String bankID) {
        super(amount);
        this.name = name;
        this.bankID = bankID;
    }
    

    @Override
    public boolean authorized() {
        //Placeholder logic for check authorization
        return true;     
    }
    
}
```
# * Class ` credit `
```

public class Credit  extends Payment{
    private String number;
    private String type;
    private String expDate;

    public Credit(float amount, String number, String type, String expDate) {
        super(amount);
        this.number = number;
        this.type = type;
        this.expDate = expDate;
    }
    
    @Override
    public boolean authorized() {
        //Placeholder logic for check authorization
        return true;
    }
}
```
<p> * Dapat disimpulkan bahwa : </p>
<p> - authorized() adalah metode yang digunakan untuk memeriksa apakah pembayaran valid.</p>
<p> - Karena Payment adalah class abstrak, metode ini harus diimplementasikan di setiap subclass (Cash, Check, Credit).</p>

# * Class `Main`
```
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

```

<P> Penjelasan : </P>
<p> - Item: Membuat dua item (KOmputer dan Headphone). </p>
<p> - OrderDetail: Menambahkan jumlah masing-masing item (1 komputer , 3 Headphone).</p>
<p> - Order: Menghitung subtotal, pajak, total pembayaran, dan total berat dari item dalam order.</P>
<p> - Customer: Menampilkan informasi pelanggan.</p>
<p> - Payment: Contoh pembayaran menggunakan Cash, Check, dan Credit, serta menampilkan status otorisasi pembayaran.</P>

# Output
![output](https://github.com/user-attachments/assets/d0b5fd04-73ec-45f1-8757-7fb1a896812a)

