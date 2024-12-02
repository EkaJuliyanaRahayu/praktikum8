
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
