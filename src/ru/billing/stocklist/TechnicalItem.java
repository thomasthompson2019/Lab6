package ru.billing.stocklist;

class TechnicalItem extends GenericItem {
    private short warrantyTime = 11; // гарантийный срок (суток)

    public void printAll() {
        super.printAll();
        System.out.printf("WarrantyTime: %d\n", warrantyTime);
    }

    public short getWarrantyTime() {
        return warrantyTime;
    }

    public void setWarrantyTime(short warrantyTime) {
        this.warrantyTime = warrantyTime;
    }
}
