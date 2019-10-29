package ru.billing.stocklist;

public class GenericItem implements Cloneable {
    private static int currentID = 1;
    private int id; // ID товара
    private String name; // Наименование товара
    private float price; //Цена товара
    private GenericItem analog;
    private Category cat;

    public GenericItem(String name, float price, Category category) {
        this.id = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.cat = category;
    }

    public GenericItem(String name, float price, GenericItem analog) {
        this.id = GenericItem.currentID++;
        this.name = name;
        this.price = price;
        this.cat = Category.GENERAL;
        if (analog != null) {
            this.analog = analog;
        }
    }

    public GenericItem() {
        this.id = GenericItem.currentID++;
        name = "DefaultName";
        price = 1.111f;
        cat = Category.GENERAL;
    }

    public void printAll() {
        System.out.printf("ID: %d , Name: %-10s , price:%5.2f, Category: %s \n", id, name, price, cat);
    }

    public boolean equals(Object o) {

        if (!(o instanceof GenericItem)) {
            return false;
        }

        GenericItem i = (GenericItem) o;
        if (this.id == i.id) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.id % 111;
    }

    public Object clone() throws CloneNotSupportedException {
        if (this.analog != null) {
            return analog.clone();
        } else {
            return super.clone();
        }
    }

    public String toString() {
        return this.name;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public GenericItem getAnalog() {
        return analog;
    }

    public void setAnalog(GenericItem analog) {
        this.analog = analog;
    }

    public Category getCat() {
        return cat;
    }

    public void setCat(Category cat) {
        this.cat = cat;
    }
}
