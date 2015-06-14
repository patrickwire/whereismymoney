package whereismymoney.floatec.de.whereismymoney;

import android.text.Editable;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by floatec on 6/13/15.
 */
public class Transaction implements Comparable<Transaction>{
    private float val;
    private double lat;
    private double lng;
    private Date time;
    private String name;


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
        this.time =  (new Date());
    }

    public int compareTo(Transaction another) {
        return(this.time.compareTo(another.time));
    }
    public Transaction(float val,double lat,double lng,Date time){
        this(val,lat,lng);
        this.time=time;
    }

    public double getLat() {
        return lat;
    }

    public double getLng() {
        return lng;
    }

    public Date getTime() {
        return time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
