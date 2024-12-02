
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
