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
}
