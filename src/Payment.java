public abstract class Payment {
    protected float amount;
    
    public Payment(float amount) {
        this.amount = amount;
    }
    
    public abstract boolean authorized();
    
}
