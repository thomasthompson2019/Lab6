package ru.billing.client;

import ru.billing.exceptions.CatalogLoadException;
import ru.billing.exceptions.ItemAlreadyExistsException;
import ru.billing.stocklist.FoodItem;
import ru.billing.stocklist.ItemCatalog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import ru.billing.client.CatalogLoader;
import ru.billing.exceptions.CatalogLoadException;
import ru.billing.stocklist.ItemCatalog;


public class CatalogFileLoader implements CatalogLoader {

    private String filePath;
    private ItemCatalog cat;

    public CatalogFileLoader(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void load(ItemCatalog cat) throws CatalogLoadException {
        File folder = new File(filePath);
        File[] listOfFiles = folder.listFiles();
        FileInputStream fis;
        String line;
        try {
            for (File file : listOfFiles) {
                if (file.isFile()) {

                    Scanner s = new Scanner(file);

                    while (s.hasNextLine()) {
                        line = s.nextLine();
                        if (line.length() == 0) {
                            break;
                        }
                        String[] item_fld = line.split(";");
                        String name = item_fld[0];
                        float price = Float.parseFloat(item_fld[1]);
                        short expires = Short.parseShort(item_fld[2]);
                        FoodItem item = new FoodItem(name, price, null, new Date(), expires);
                        cat.addItem(item);


                    }


                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ItemAlreadyExistsException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }


}
