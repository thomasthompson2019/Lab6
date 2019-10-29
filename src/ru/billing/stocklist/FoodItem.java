package ru.billing.stocklist;

import java.util.Date;

public class FoodItem extends GenericItem {
    private Date dateOfIncome = new Date(); // дата производства
    private short expires = 111; // срок годности


    public FoodItem(String name, float price, FoodItem analog, Date date, short expires) {
        super(name, price, analog);
        this.dateOfIncome = date;
        this.expires = expires;
    }

    public FoodItem(String name, float price, short expires) {
        //new FoodItem(name, price, Category.GENERAL, new Date(), expires);
        this(name, price, null, new Date(), expires);
    }

    public FoodItem(String name, float price, Category general) {
        this(name, 1.111f, null, new Date(), (short) 111);
    }

    public void printAll() {
        super.printAll();
        System.out.printf("Date: %s , expires: %d \n", dateOfIncome, expires);
    }

    public Date getDateOfIncome() {
        return dateOfIncome;
    }

    public void setDateOfIncome(Date dateOfIncome) {
        this.dateOfIncome = dateOfIncome;
    }

    public short getExpires() {
        return expires;
    }

    public void setExpires(short expires) {
        this.expires = expires;
    }
}
