package domain;

import java.io.Serializable;
import java.util.Date;

public class westernPatry extends Pastry implements Serializable {
    public westernPatry(int id, String name, float price, String produceDate, String state) {
        super(id, name, price, produceDate, state);
    }
}
