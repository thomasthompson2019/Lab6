package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.*;
import ru.billing.sync.U1901Main;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //6-1
        System.out.println("-----6-1-----");
        ItemCatalog ic = new ItemCatalog();
        for (char ch = 'A'; ch < 'A' + 10; ch++) {
            FoodItem gi = new FoodItem(Character.toString(ch), 2.5f + ch, Category.GENERAL);
            try {
                ic.addItem(gi);
            } catch (ItemAlreadyExistsException e) {
                e.printStackTrace();
            }
            gi.printAll();
        }

        //6-3
        System.out.println("-----6-3-----");
        ItemCatalog ic2 = new ItemCatalog();
        CatalogFileLoader cfl = new CatalogFileLoader("files");
        try {
            cfl.load(ic2);
        } catch (CatalogLoadException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.fillInStackTrace();
        }
        ic2.printItems();

        //6-2
        System.out.println("-----6-2-----");
        U1901Main.runThreads();
    }
}
