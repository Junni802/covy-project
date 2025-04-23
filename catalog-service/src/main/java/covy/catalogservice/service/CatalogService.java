package covy.catalogservice.service;

import covy.catalogservice.entity.CatalogEntity;

/**
 * <클래스 설명>
 *
 * @author : junni802
 * @date : 2025-02-25
 */
public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();

}
