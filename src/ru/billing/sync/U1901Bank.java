package ru.billing.sync;

public class U1901Bank {
    private int intTo;
    private int intFrom = 220;

    public synchronized void calc(int intTransaction, long lngTimeout) {
        System.out.println("Values before - intTo: " + intTo +
                          " intFrom: " + intFrom +
                         ". Thread name: " + Thread.currentThread().getName());
        intFrom -= intTransaction;
        try {
            Thread.sleep(lngTimeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        intTo += intTransaction;
        System.out.println("Values after - intTo: " + intTo +
                          " intFrom: " + intFrom +
                         ". Thread name: " + Thread.currentThread().getName());
    }
}
