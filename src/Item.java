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



