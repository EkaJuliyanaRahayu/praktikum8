
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

