package whereismymoney.floatec.de.whereismymoney;

/**
 * Created by floatec on 6/13/15.
 */
public class Transaction {
    private float val;
    private double lat;
    private double lng;


    public float getValue() {
        return val;
    }

    public void setValue(float val) {
        this.val = val;
    }
    public Transaction(float val,double lat,double lng){
        this.val=val;
        this.lat=lat;
        this.lng =lng;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }
}
