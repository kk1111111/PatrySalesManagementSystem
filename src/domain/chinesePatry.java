package domain;

import java.io.Serializable;
import java.util.Date;

public class chinesePatry extends Pastry implements Serializable {
    public chinesePatry(int id, String name, float price, String produceDate, String state) {
        super(id, name, price, produceDate, state);
    }
}
