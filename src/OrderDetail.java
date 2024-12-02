
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
