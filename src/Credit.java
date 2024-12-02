
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
