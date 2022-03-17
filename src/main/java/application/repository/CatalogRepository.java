package application.repository;

import application.entity.Catalog;

public interface CatalogRepository {
    int[] saveCatalogBooks(Catalog catalog);
}
