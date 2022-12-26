package domain;

import java.util.Date;

class Pastry {
    int id;
    String name;
    float price;
    String produceDate;
    String state;

    public Pastry(int id, String name, float price, String produceDate, String state) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.produceDate = produceDate;
        this.state = state;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProduceDate() {
        return this.produceDate;
    }

    public void setProduceDate(String produceDate) {
        this.produceDate = produceDate;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

