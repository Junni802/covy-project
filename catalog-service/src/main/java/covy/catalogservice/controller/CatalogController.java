package covy.catalogservice.controller;

import covy.catalogservice.entity.CatalogEntity;
import covy.catalogservice.service.CatalogService;
import covy.catalogservice.vo.ResponseCatalog;
import java.util.ArrayList;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <클래스 설명>
 *
 * @author : junni802
 * @date : 2025-02-25
 */

@RestController
@RequestMapping("/catalog-service")
public class CatalogController {

    Environment env;
    CatalogService catalogService;

    @Autowired
    public CatalogController(Environment env, CatalogService catalogService) {
        this.env = env;
        this.catalogService = catalogService;
    }

    @GetMapping("/heath_check")
    public String status() {
        return String.format("It's Working in User Service On PORT %s", env.getProperty("local.server.port"));
    }

    @GetMapping("/users")
    public ResponseEntity<List<ResponseCatalog>> getUsersAll() {
        Iterable<CatalogEntity> userList = catalogService.getAllCatalogs();

        List<ResponseCatalog> resut = new ArrayList<>();
        userList.forEach(v -> {
            resut.add(new ModelMapper().map(v, ResponseCatalog.class));
        });

        return ResponseEntity.status(HttpStatus.OK).body(resut);
    }
}
