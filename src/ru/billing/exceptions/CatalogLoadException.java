package ru.billing.exceptions;

import java.io.FileNotFoundException;

public class CatalogLoadException extends Exception {

    public CatalogLoadException(ItemAlreadyExistsException e) {}

    public CatalogLoadException(FileNotFoundException e) {}
}
