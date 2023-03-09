package domain;

import java.io.Serializable;

public class sale implements Serializable{
    int id;
    String date;
    String method;
    float sum;
    public sale(int id,String date,String method,float sum){
        this.id=id;
        this.date=date;
        this.method=method;
        this.sum=sum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public float getSum() {
        return sum;
    }

    public void setSum(float sum) {
        this.sum = sum;
    }
}
