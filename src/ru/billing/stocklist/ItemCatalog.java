package ru.billing.stocklist;

import ru.billing.exceptions.ItemAlreadyExistsException;
import java.util.ArrayList;
import java.util.HashMap;

public class ItemCatalog {
    private HashMap<Integer, GenericItem> catalog = new HashMap<Integer, GenericItem>();
    private ArrayList<GenericItem> alCatalog = new ArrayList<GenericItem>();

    public void addItem(GenericItem item) throws ItemAlreadyExistsException {
        if (findItemByID(item.getID()) == null) {
            catalog.put(item.getID(), item);
            alCatalog.add(item);
        } else {
            throw new ItemAlreadyExistsException();
        }

    }

    public void printItems() {
        for (GenericItem item : alCatalog) {
            System.out.println("------------------------------------------------");
            item.printAll();
        }
    }

    public GenericItem findItemByID(int id) {
        if (!catalog.containsKey(id)) {
            return null;
        } else {
            return catalog.get(id);
        }
    }

    public GenericItem findItemByIDAL(int id) {
        for (GenericItem i : alCatalog) {
            if (i.getID() == id) {
                return i;
            }
        }
        return null;
    }

    public HashMap<Integer, GenericItem> getCatalog() {
        return catalog;
    }

    public void setCatalog(HashMap<Integer, GenericItem> catalog) {
        this.catalog = catalog;
    }

    public ArrayList<GenericItem> getAlCatalog() {
        return alCatalog;
    }

    public void setAlCatalog(ArrayList<GenericItem> alCatalog) {
        this.alCatalog = alCatalog;
    }
}
